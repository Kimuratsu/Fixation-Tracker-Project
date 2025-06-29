// Stuff below is to be tossed into other classes later
import java.time.Instant;
// Same as before but its just there to catch exceptions
import java.io.IOException;

// These three are needed for the code to read the filepaths used for my text document writing solution
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        ///
        /// Stuff below is about the timer behaviour
        ///

        /// Calling the TimerValueConverter Class
        TimerValueConverter timerValueConverter = new TimerValueConverter();
        TimerHandler timerHandler = new TimerHandler();

        /// TEST INPUT TO BE REPLACED BY USER INPUT
        String testWoodType = "Pine";

        /// TEST TIMERS TO BE REPLACED BY PROPER TIMER HANDLING
        Instant testStartTimer = timerHandler.NewTimerStart();
        Instant testNewTimerEnd = timerHandler.NewTimer(testWoodType);

        /// Converting our timer Start and End to a formatted String as per TVC Class
        String startDateTime = timerValueConverter.ConvertToZoneDateTime(testStartTimer);
        String endDateTime = timerValueConverter.ConvertToZoneDateTime(testNewTimerEnd);

        System.out.println("Starting time is " + startDateTime + " and ending time is " + endDateTime);

        ///
        /// Stuff below this is about creating a text document in the files with some sample text
        ///

        //some variables needed for the code below,
        //specifically file contents
        String content = "test of what gets written into the NoteStorage directory";
        //the subdirectory, this one will likely not change for this project
        String subdirectory = "NoteStorage";
        //the name of the file
        String filename = "test.txt";

        //this tries to make a text file with name and contents specified above
        //its going to overwrite whatever file was there previously though so would be good to
        //make the final code always create either a unique seed or just make a new file by incrementing
        //some number, and then having it read what the highest number is before it does the action
        //its probably going to be pretty slow but i can afford that for now
        //if its too cumbersome ill fix it later, i dont [[think]] its unfixable
        try
        {
            //creates path if needed, just a precaution to not need to make an exception
            Path dirPath = Paths.get(subdirectory);
            if(!Files.exists(dirPath))
            {
                Files.createDirectory(dirPath);
            }

            //this creates a file in the specific filepath
            Path filePath = dirPath.resolve(filename);

            //this writes the contents
            Files.write(filePath, content.getBytes());
            System.out.println("File written to " + filePath);
        }
        //this is a necessary exception thrower, basically catching if anything unexpected happened
        //while making the file
        catch (IOException e)
        {
            System.err.println("Error writing to file: " +  e.getMessage());
        }


        /// Stuff below this is just templates for making sure I remember how OOP stuff is even coded
        /// in Java
        // Basically all the stuff below is just a temporary template for myself to understand
        // Polymorphism, Inheritance, Encapsulation and probably Abstraction within Java
        // It's gonna get removed by the final git commit when I send my project over
        // But if you're checking the older commits, hi! Hope my lame humour gave you a laugh.

        // okay no abstraction because im lazy and it would take more writing than its worth for a template
        System.out.println();
        TherapyCheckup therapyCheckup = new TherapyCheckup();

        MyBraincells braincells = new MyBraincells("Braincells", 4);
        IQPoints iq = new IQPoints("IQ Points", 8, false);
        Thoughts thoughts = new Thoughts(1236, "Unrelated", "Thoughts");

        therapyCheckup.addBraincell(braincells);
        therapyCheckup.addBraincell(iq);
        therapyCheckup.addBraincell(thoughts);

        therapyCheckup.displayTherapyCheckup();

        System.out.println();

        System.out.println("This is a test because apparently I need to rethink my life lol");
    }
}
