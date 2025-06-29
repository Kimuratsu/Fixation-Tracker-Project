public class MyBraincells
{
    // so this is obviously kind of a joke thing ive decided to put in here because i was bored of
    // studying for the other exams and realised i needed to actually *write* the code in here
    // instead of just spending another week writing out how i want it to work
    // came back, realised things aren't working very well, didn't want to git commit a broken piece of code
    // then removed like, everything and now here we are
    // this is going to be my little template and syntax test for how to actually write the object oriented
    // code + idk its going to be funny to see a commit that basically just adds a tiny feature and
    // +2 braincells
    // also this is probably going to be called a miku commit because its an inside joke with my [actual]
    // programmer friend lol

    private String name;
    private int quantity;

    public MyBraincells(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    @Override
    public String toString()
    {
        return "What's this: " + name + ", Amount: " + quantity;
    }
}
