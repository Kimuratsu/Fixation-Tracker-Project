import java.time.Instant;

public class TimerHandler
{
    public Instant NewTimerStart()
    {
        return Instant.now();
    }

    public Instant NewTimer(String WoodType)
    {
        Instant now = Instant.now();
        Instant endTime = switch (WoodType)
        {
            /// Fun fact, while it varies on a case-by-case basis, the density of wood and its structure
            /// does affect the burn-time, hence why Pine, a softwood, burns less than Oak, a hardwood
            case "Pine" -> endTime = now.plusSeconds(300);
            case "Birch" -> endTime = now.plusSeconds(600);
            case "Oak" -> endTime = now.plusSeconds(3600);
            default -> endTime = now; /// If this happens, assume I messed up big time
        }; /// This just feels uncomfortable.

        return endTime;
    }
}
