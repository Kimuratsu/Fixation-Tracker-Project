import java.util.ArrayList;

public class TherapyCheckup
{
    private ArrayList<MyBraincells> braincells;

    public TherapyCheckup()
    {
        braincells = new ArrayList<>();
    }

    public void addBraincell(MyBraincells brainscan)
    {
        braincells.add(brainscan);
    }

    public void displayTherapyCheckup()
    {
        for(MyBraincells stateofbren : braincells)
        {
            System.out.println(stateofbren.toString());
        }
    }
}
