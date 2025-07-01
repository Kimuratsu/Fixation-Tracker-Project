public class Pinecone implements KindlingType
{
    @Override public int getMaxLength()
    {
        return 200;
    }
    @Override public String getName()
    {
        return "Pinecone";
    }
    @Override public String toString()
    {
        return getName();
    }
}
