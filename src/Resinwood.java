public class Resinwood implements KindlingType
{
    @Override public int getMaxLength()
    {
        return 500;
    }
    @Override public String getName()
    {
        return "Resinwood";
    }
    @Override public String toString()
    {
        return getName();
    }
}
