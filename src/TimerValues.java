import java.time.Instant;

public class TimerValues
{
    // getting a variable for the timer start
    private Instant startTime;
    private Instant endTime;
    private long endTimeInMillis;


    public TimerValues(Instant startTime, Instant endTime, long endTimeInMillis)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.endTimeInMillis = endTimeInMillis;
    }


    // actually assigning a value to the timer start [aka like, right as it's called]
    public void getStartTime()
    {
        startTime = Instant.now();
    }

    // assigning an end to the timer, HARDCODED TO 30 SECONDS ATM, PLS CHANGE PLS PLS PLSSS
    public void getEndTime()
    {
        endTime = startTime.plusSeconds(30);
    }

    // getting the end timer in milliseconds
    public long getEndTimeInMillis()
    {
        return endTime.toEpochMilli();
    }

}

