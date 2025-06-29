import javax.xml.namespace.QName;

// Stuff below is to be tossed into other classes later
// Used to get the current time
import java.io.File;
import java.time.Instant;
// Used for the current timezone on this machine
import java.time.ZoneId;
// Variable type that stores the date and time, confirm this later tho I just found this solution online
import java.time.ZonedDateTime;
// Standard java package formatter for date and time, full list of options will be left below
// MOVE TO THE README LATER
import java.time.format.DateTimeFormatter;
// An input-output import that will let the program make text files
import java.io.FileWriter;
// Same as before but its just there to catch exceptions
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        ///
        /// Stuff below is about the timer behaviour
        ///

        Instant startTime = Instant.now();
        //assigning end of the timer, currently hardcoded to 60 seconds
        Instant endTime = startTime.plusSeconds(60);

        //start and end time in just a singular number [milliseconds since some preset date]
        //leaving here in case i need it for data storage purposes
        long startTimeInMillis = startTime.toEpochMilli();
        long endTimeInMillis = endTime.toEpochMilli();

        //once this will be moved into its own class replace 'zdt' with something more generic
        //but what this does is basically convert startTime into a variable that respects the machine's
        //timezone and stuff
        ZonedDateTime zdt = startTime.atZone(ZoneId.systemDefault());
        //and this takes that variable and puts it through DateTimeFormatter to make a nice output
        String startDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(zdt);
        ZonedDateTime zdt2 = endTime.atZone(ZoneId.systemDefault());
        String endDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(zdt2);

        System.out.println("Starting time is " + startDateTime + " and ending time is " + endDateTime);

        ///
        /// Stuff below this is about creating a text document in the files with some sample text
        ///

        //this will attempt to make a new text file with the name "test.txt"
        //its going to overwrite whatever file was there previously though so would be good to
        //make the final code always create either a unique seed or just make a new file by incrementing
        //some number, and then having it read what the highest number is before it does the action
        //its probably going to be pretty slow but i can afford that for now
        //if its too cumbersome ill fix it later, i dont [[think]] its unfixable
        try (FileWriter writer = new FileWriter("test.txt"))
        {
            //this is what will be inside the text file
            writer.write("test2");
            //and this is just the confirmation in runtime that it was successful
            System.out.println("File written");
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

        MyBraincells braincells = new MyBraincells("Braincells", 2);
        IQPoints iq = new IQPoints("IQ Points", 10, false);
        Thoughts thoughts = new Thoughts(572, "Unrelated", "Thoughts");

        therapyCheckup.addBraincell(braincells);
        therapyCheckup.addBraincell(iq);
        therapyCheckup.addBraincell(thoughts);

        therapyCheckup.displayTherapyCheckup();

        System.out.println();

        System.out.println("This is a test because apparently I need to rethink my life lol");
    }
}

// All the stuff for DateTimeFormatter
//    HH - 24-hour format hour
//    hh - 12-hour format hour [might need to use 'a' after this to add the am/pm marker]
//    mm - minutes
//    ss - seconds
//    dd - day of month
//    MM - month
//    yyyy - year
//    a - AM/PM marker