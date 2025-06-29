import javax.xml.namespace.QName;

public class Main
{
    public static void main(String[] args)
    {




        // Basically all the stuff below is just a temporary template for myself to understand
        // Polymorphism, Inheritance, Encapsulation and probably Abstraction within Java
        // It's gonna get removed by the final git commit when I send my project over
        // But if you're checking the older commits, hi! Hope my lame humour gave you a laugh.

        // okay no abstraction because im lazy and it would take more writing than its worth for a template
        TherapyCheckup therapyCheckup = new TherapyCheckup();

        MyBraincells braincells = new MyBraincells("Braincells", 2);
        IQPoints iq = new IQPoints("IQ Points", 10, false);
        Thoughts thoughts = new Thoughts(572, "Unrelated", "Thoughts");

        therapyCheckup.addBraincell(braincells);
        therapyCheckup.addBraincell(iq);
        therapyCheckup.addBraincell(thoughts);

        therapyCheckup.displayTherapyCheckup();

        System.out.println("This is a test because apparently I need to rethink my life lol");
    }
}
