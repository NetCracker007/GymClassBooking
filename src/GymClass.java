public class GymClass {
    private int id;
    private String name;
    private String description;
    private int maxCapacity;
    private int currentBookings;
    private ClassTimings classTimings;

    public ClassTimings getClassTimings() {
        return classTimings;
    }

    public void setClassTimings(ClassTimings classTimings) {
        this.classTimings = classTimings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    public void setCurrentBookings(int currentBookings) {
        this.currentBookings = currentBookings;
    }

    public boolean isAvailable()
    {
        return !(maxCapacity == currentBookings);
    }

    public void book() throws Exception
    {
        if (isAvailable())
        {
            currentBookings ++;
        }
        else
        {
            throw new Exception("Class is full");
        }
    }

    public void cancel() throws Exception
    {
        if (currentBookings >= 1)
        {
            currentBookings -- ;
        }
        else
        {
            throw new Exception("No bookings to cancel");
        }
    }
}
