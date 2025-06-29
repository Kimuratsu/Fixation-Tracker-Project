import java.util.ArrayList;
import java.util.List;

public class AppState
{
    /// This handles all the parts of CampfireCombination as an array inside the JSON
    private List<CampfireCombination> fileCampfires = new ArrayList<>();

    /// Getter / Setter stuff for JSON
    public List<CampfireCombination> getFileCampfires()
    {
        return fileCampfires;
    }
    public void setFileCampfires(List<CampfireCombination> fileCampfires)
    {
        this.fileCampfires = fileCampfires;
    }
}
