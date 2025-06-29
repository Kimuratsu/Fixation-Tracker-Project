public class CampfireCombination
{
    /// Declaration of all the variables that will be handled and saved in a JSON file
    private String fileName;
    private String fileType;
    private int campfireID;
    private long timerValue;

    /// Necessary Constructor for JSON
    public CampfireCombination() {}

    public CampfireCombination(String fileName, String fileType, int campfireID, long timerValue)
    {
        this.fileName = fileName;
        this.fileType = fileType;
        this.campfireID = campfireID;
        this.timerValue = timerValue;
    }


    /// Everything below is the get / set stuff required for a JSON file when the fields are private
    public String getFileName()
    {
        return fileName;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileType()
    {
        return fileType;
    }
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public int getCampfireID()
    {
        return campfireID;
    }
    public void setCampfireID(int campfireID)
    {
        this.campfireID = campfireID;
    }

    public long getTimerValue()
    {
        return timerValue;
    }
    public void setTimerValue(long timerValue)
    {
        this.timerValue = timerValue;
    }
}
