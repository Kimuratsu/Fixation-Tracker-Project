public class Thoughts extends MyBraincells
{
    private String type;

    public Thoughts(int quantity, String type, String name)
    {
        super(name, quantity);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
}
