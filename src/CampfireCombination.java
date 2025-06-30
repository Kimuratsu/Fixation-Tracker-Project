import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
@JsonIgnoreProperties(ignoreUnknown = true)

public class CampfireCombination
{
    /// Declaration of all the variables that will be handled and saved in a JSON file
    private String fileName;
    private String fileType;
    private int campfireID;
    private long timerValue;
    private String timerType;

    /// Necessary Constructor for JSON
    public CampfireCombination() {}

    public CampfireCombination(String fileName, String fileType, int campfireID, long timerValue, String timerType)
    {
        this.fileName = fileName;
        this.fileType = fileType;
        this.campfireID = campfireID;
        this.timerValue = timerValue;
        this.timerType = timerType;
    }


    /// Helper method that fetches a timer's "remaining time" and formats it
    public String getRemainingTimeFormatted()
    {
        long remainingSeconds = (timerValue - System.currentTimeMillis()) / 1000;

        if(remainingSeconds <= 0)
        {
            return "Expired";
        }

        Duration duration = Duration.ofSeconds(remainingSeconds);
        long days = duration.toDays();
        long hours = duration.toHours() %24;
        long minutes = duration.toMinutes() %60;
        long seconds = duration.getSeconds() %60;

        StringBuilder sb = new StringBuilder();
        if (days > 0) sb.append(days).append(" days");
        if (hours > 0 || days > 0) sb.append(hours).append(" hours");
        if (minutes > 0 || hours > 0 || days > 0) sb.append(minutes).append(" minutes");
        sb.append(seconds).append(" seconds");

        return sb.toString();
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

    public String getTimerType()
    {
        return timerType;
    }
    public void setTimerType(String timerType)
    {
        this.timerType = timerType;
    }
}
