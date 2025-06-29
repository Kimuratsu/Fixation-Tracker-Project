import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService
{
    private static final String STATE_FILE = "file_campfires.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveState(List<CampfireCombination> fileCampfires) throws Exception
    {
        AppState appState = new AppState();
        appState.setFileCampfires(fileCampfires);
        mapper.writeValue(new File(STATE_FILE), appState);
    }

    public static List<CampfireCombination> loadState() throws Exception
    {
        File appStateFile = new File(STATE_FILE);
        if(!appStateFile.exists())
        {
            return new ArrayList<>();
        }

        AppState appState = mapper.readValue(appStateFile, AppState.class);
        return appState.getFileCampfires() != null ? appState.getFileCampfires() : new ArrayList<>();
    }
}
