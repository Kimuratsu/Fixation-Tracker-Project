import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileHandler
{
    public void NewNote(String content, String subdirectory) throws Exception {

        int id = PersistenceService.getTotalTimerCount() + 1;
        String filename = "test" + id + ".txt";

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

    public boolean isAppropriateLength(String content, KindlingType kindlingType)
    {
        return content.length() <= kindlingType.getMaxLength();
    }

}
