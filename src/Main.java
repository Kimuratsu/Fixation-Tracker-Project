import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {

        /// Calling the TimerValueConverter Class and the TextFileHandler Class
        TimerValueConverter timerValueConverter = new TimerValueConverter();
        TimerHandler timerHandler = new TimerHandler();
        TextFileHandler textFileHandler = new TextFileHandler();

        ///
        /// Below is the final "production code" that I'll be using for allowing for user input and
        /// interaction with the code. It's unlikely much of it will remain if the UI gets implemented
        /// but I needed *something* to show that the code is working and can be used and this was
        /// my best bet. Also I tried to at least format it nicely
        ///

        /// All the various variables I randomly added in to make the front-end user interfacing work
        String state = "View or Add";
        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean isValidLength;
        String timerFuel;
        String kindlingType;
        String noteContents;
        Instant newTimer;

        System.out.println();
        System.out.println("Hello, this code is meant to allow for quick and easy creation of 'campfires'");
        System.out.println("A 'campfire' is a combination of a timer and an associated note, used for " +
                "quickly making a tracker of random thoughts and ideas for focusing on them while the timer lasts");
        System.out.println("'Campfires' are made through adding some 'fuel' alongside 'kindling' and lighting them");
        System.out.println("The 'fuel' is our timer and the 'kindling' is our type [length] of a note");
        System.out.println();

        do
        {
            System.out.println("Would you like to view 'Lit' Campfires, light a New Campfire, or Exit?");

            System.out.println("Please type: ");
            System.out.println("- '1' or 'View' to View Burning Campfires");
            System.out.println("- '2' or 'Add' to Add a new Campfire");
            System.out.println("- '3' or 'Exit' to Exit");
            System.out.print("Please enter a valid option: ");
            userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput)
            {
                case "1":
                case "view": state = "ViewingOnGoing"; break;
                case "2":
                case "add": state = "LightningNew"; break;
                case "3":
                case "exit": state = "Exiting"; break;
                default: System.out.println("It would appear that the input is invalid, please " +
                        "try again"); break;
            }

            while(state.equals("ViewingOnGoing"))
            {
                System.out.println("Here is a list of all 'Lit Campfires'");
                PersistenceService.printActiveTimers();
                System.out.println();
                System.out.println("You will now be returned back to the main menu");
                state = "View or Add";
            }

            while(state.equals("LightningNew"))
            {
                timerFuel = ("alwaysbreakatstart");
                kindlingType = ("alwaysbreakatstart");

                System.out.println("To light a campfire, you will need to choose a type of fuel [timer " +
                        "length], a type of kindling [length of note] and then write the contents");
                System.out.println("Please select a type of fuel: ");
                System.out.println("- '1' or 'Pine' for a 5 minute timer ");
                System.out.println("- '2' or 'Birch' for a 10 minute timer ");
                System.out.println("- '3' or 'Oak' for a 60 minute timer");
                System.out.print("Please enter a valid option: ");
                timerFuel = scanner.nextLine().trim().toLowerCase();

                switch (timerFuel)
                {
                    case "1":
                    case "pine": timerFuel = "Pine"; break;
                    case "2":
                    case "birch": timerFuel = "Birch"; break;
                    case "3":
                    case "oak": timerFuel = "Oak"; break;
                    default: System.out.println("It would appear that the input is invalid, please " +
                            "try again"); break;
                }

                if(timerFuel.equals("Pine") || timerFuel.equals("Birch") || timerFuel.equals("Oak"))
                {
                    System.out.println("Please select a type of kindling: ");
                    System.out.println("- '1' or 'Sage' for a 50 character note ");
                    System.out.println("- '2' or 'Pinecone' for a 200 character note ");
                    System.out.println("- '3' or 'Resinwood' for a 500 character note");
                    System.out.print("Please enter a valid option: ");
                    kindlingType = scanner.nextLine().trim().toLowerCase();

                    switch (kindlingType)
                    {
                        case "1":
                        case "sage": kindlingType = "Sage"; break;
                        case "2":
                        case "pinecone": kindlingType = "Pinecone"; break;
                        case "3":
                        case "resinwood": kindlingType = "Resinwood"; break;
                        default: System.out.println("It would appear that the input is invalid, please " +
                                "try again"); break;
                    }

                    if(kindlingType.equals("Sage") || kindlingType.equals("Pinecone")
                            || kindlingType.equals("Resinwood"))
                    {
                        noteContents = ("alwaysbreakatstart");

                        do
                        {
                            System.out.println("Thank you, your " + timerFuel + " campfire is being " +
                                    "lit using " + kindlingType + " as fuel");
                            System.out.println("Please add the desired note now:");

                            noteContents = scanner.nextLine();

                            isValidLength = textFileHandler.isAppropriateLength(noteContents, kindlingType);

                            if(!isValidLength) System.out.println("Note is too long! The query will now repeat," +
                                    " feel free to copy previous note to trim it appropriately.");
                        }
                        while (!isValidLength);

                        textFileHandler.NewNote(noteContents, "NoteStorage");
                        newTimer = timerHandler.NewTimer(timerFuel);
                        int id = PersistenceService.getTotalTimerCount()+1;
                        String fileName = "test" + id + ".txt";

                        try
                        {
                            List<CampfireCombination> fileCampfires = PersistenceService.loadState();

                            fileCampfires.add(new CampfireCombination(fileName, kindlingType, id, timerValueConverter.ConvertToMillis(newTimer), timerFuel));

                            PersistenceService.saveState(fileCampfires);

                            ///
                            /// This is a test to see how the file structure will look like when printed directly
                            ///

                            System.out.println();
                            System.out.println("Saved JSON structure:");
                            System.out.println(new String(Files.readAllBytes(Paths.get("file_campfires.json"))));

                            ///
                            /// by the program
                            ///

                            /// This for the most part just shows how many timers [on-going and otherwise] are saved
                            /// In the JSON file
                            List<CampfireCombination> loadedFileCampfires = PersistenceService.loadState();
                            System.out.println();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

                state = "View or Add";
            }

            /// This exits the do while loop, there's probably a more elegant way to do this, but I'll
            /// fix it once the more important functionality is finished
            while (state.equals("Exiting"))
            {
                System.out.println("The program will now close, thank you for checking out the Campfire" +
                        " Fixation Tracker!");
                break;
            }
        }
        while(state.equals("View or Add"));
    }
}
