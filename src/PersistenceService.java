import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService
{
    /// Saves the save-state in this JSON file
    private static final String STATE_FILE = "file_campfires.json";
    /// Basically makes the JSON look a little nicer
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    /// This saves basically all the data from the list into an Appstate that we will call to later
    public static void saveState(List<CampfireCombination> fileCampfires) throws Exception
    {
        AppState appState = new AppState();
        appState.setFileCampfires(fileCampfires);
        mapper.writeValue(new File(STATE_FILE), appState);
    }

    /// Loads and returns the list
    public static List<CampfireCombination> loadState() throws Exception {
        File appStateFile = new File(STATE_FILE);
        if (!appStateFile.exists()) {
            return new ArrayList<>();
        }

        /// This is the part that returns the list
        try
        {
            AppState appState = mapper.readValue(appStateFile, AppState.class);
            return appState.getFileCampfires() != null ? appState.getFileCampfires() : new ArrayList<>();
        }
        catch (Exception e)
        {
            System.err.println("Error loading state (possible deleted file): " + e.getMessage());
            /// Added after I deleted JSON contents by "accident", this will resolve the issue
            /// By falling back to an empty array
            return new ArrayList<>();
        }
    }
}

///Note to both self and basically anyone reading this:
///I have a very surface-level understanding of saving things to a JSON file because it was simply
///out of the scope of the project, but saving data between sessions felt pretty crucial to the core
///idea of *this* project specifically.
///This is why the comments here [and my understanding] are a fair bit less all-encompassing
///and less useful. Once I get around to pushing this project further to including UI and such this will
///likely get a small [or not so small] update to both optimise this and properly comment things