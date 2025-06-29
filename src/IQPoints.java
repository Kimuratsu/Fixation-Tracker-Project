public class IQPoints extends MyBraincells
{
    private boolean isReal;

    public IQPoints(String name, int quantity, boolean isReal)
    {
        super(name, quantity);
        this.isReal = isReal;
    }

    @Override
    public String toString()
    {
        return getQuantity() + " " + getName() + ". Is IQ Real? " + isReal;
    }
}
