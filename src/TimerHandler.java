import java.time.Instant;

public class TimerHandler
{
    public Instant NewTimerStart()
    {
        return Instant.now();
    }

    public Instant NewTimer(WoodType wood)
    {
        return Instant.now().plusSeconds(wood.getBurnDurationSeconds());
    }
}
