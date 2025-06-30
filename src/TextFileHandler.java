import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileHandler
{
    public void NewNote(String content, String subdirectory)
    {
        /// IMPORTANT!!! The name of the file is hardcoded right now and WILL overwrite the previous
        /// Test file. Fix this by either making the user input the name [undesirable change]
        /// or by adding that ID system via further inheritance (?) and linking the timers with notes
        String filename = "test.txt";

        try
        {
            /// Creates path if needed, replacement for exception handling
            Path dirPath = Paths.get(subdirectory);
            if(!Files.exists(dirPath))
            {
                Files.createDirectory(dirPath);
            }

            /// This creates a file in the specific filepath
            Path filePath = dirPath.resolve(filename);

            /// This writes the contents
            Files.write(filePath, content.getBytes());
            System.out.println("File written to " + filePath);
        }
        /// This is a necessary exception thrower, catching if anything unexpected happened
        /// while making the file
        catch (IOException e)
        {
            System.err.println("Error writing to file: " +  e.getMessage());
        }
    }

    public boolean isAppropriateLength(String content, String noteType)
    {
        int allowedLength;

        switch(noteType)
        {
            case "Sage" ->  allowedLength = 50;
            case "Pinecone" -> allowedLength = 200;
            case "Resinwood" -> allowedLength = 500;
            default -> allowedLength = 0;
        }

        return content.length() <= allowedLength;
    }

}
