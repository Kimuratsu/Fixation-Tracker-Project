import java.time.Instant;

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

        TextFileHandler textFileHandler = new TextFileHandler();

        /// This creates a new note in the /NoteStorage subdirectory
        /// This test currently overwrites the previous note which NEEDS TO BE FIXED VIA ID SYSTEM
        /// The ID system could either be a specific unique Seed, or simple file incrementation
        /// The solution present in the final project I send is likely unoptimised, but such is life
        /// It can and will be fixed, but I couldn't dwell on that detail at the moment
        textFileHandler.NewNote("Test of what gets written into the subdirectory", "NoteStorage");

        /// Stuff below this is just templates for making sure I remember how OOP stuff is even coded
        /// in Java
        // Basically all the stuff below is just a temporary template for myself to understand
        // Polymorphism, Inheritance, Encapsulation and probably Abstraction within Java
        // It's gonna get removed by the final git commit when I send my project over
        // But if you're checking the older commits, hi! Hope my lame humour gave you a laugh.

        // okay no abstraction because im lazy and it would take more writing than its worth for a template
        System.out.println();
        TherapyCheckup therapyCheckup = new TherapyCheckup();

        MyBraincells braincells = new MyBraincells("Braincells", 5);
        IQPoints iq = new IQPoints("IQ Points", 12, false);
        Thoughts thoughts = new Thoughts(2738, "Unrelated", "Thoughts");

        therapyCheckup.addBraincell(braincells);
        therapyCheckup.addBraincell(iq);
        therapyCheckup.addBraincell(thoughts);

        therapyCheckup.displayTherapyCheckup();

        System.out.println();

        System.out.println("This is a test because apparently I need to rethink my life lol");
    }
}
