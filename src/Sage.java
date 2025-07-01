public class Sage implements KindlingType
{
    @Override public int getMaxLength()
    {
        return 50;
    }
    @Override public String getName()
    {
        return "Sage";
    }
    @Override public String toString()
    {
        return getName();
    }
}
