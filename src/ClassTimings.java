public class ClassTimings {
    private String startTime;
    private String endTime;

    public ClassTimings(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString()
    {
        return startTime + ":" + endTime;
    }
}
