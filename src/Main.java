import java.time.Instant;
import java.util.List;

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

        ///
        /// Stuff below is the combination of Timers and Notes, but mostly the handling of the JSON file
        ///

        try
        {
            List<CampfireCombination> fileCampfires = PersistenceService.loadState();

            fileCampfires.add(new CampfireCombination("test.txt", "Pinecone", 1, timerValueConverter.ConvertToMillis(testNewTimerEnd)));

            PersistenceService.saveState(fileCampfires);

            List<CampfireCombination> loadedFileCampfires = PersistenceService.loadState();
            System.out.println("Stored Campfires: " + loadedFileCampfires.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
