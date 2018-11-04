import java.util.List;
import java.util.Map;

public class ClassBookingSystem {
    private List<GymCenter> gymCenters;
    private Map<String, List<GymClass>> listOfClasses;

    public List<GymCenter> getGymCenters() {
        return gymCenters;
    }

    public void setGymCenters(List<GymCenter> gymCenters) {
        this.gymCenters = gymCenters;
    }

    public Map<String, List<GymClass>> getListOfClasses() {
        return listOfClasses;
    }

    public void setListOfClasses(Map<String, List<GymClass>> listOfClasses) {
        this.listOfClasses = listOfClasses;
    }

    public void displayLocations()
    {
        for(GymCenter gymCenter: gymCenters)
        {
            System.out.println(gymCenter.getLocationId());
        }
    }

    public void displayLocationBasedClasses(String locationId)
    {
        if (listOfClasses.get(locationId) != null)
        {
            List<GymClass> classes = listOfClasses.get(locationId);
            for(GymClass gymClass: classes)
            {
                System.out.println(gymClass.getId() + "->" + gymClass.getName() + "->" + gymClass.getClassTimings());
            }
        }
        else
        {
            System.out.println("Please enter a valid locationId");
        }
    }

    public void bookClass(int userId, GymClass gymClass)
    {
        if (gymClass.isAvailable())
        {
            try {
                gymClass.book();
                System.out.println("Class booked successfully!");

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Class is full!");
        }
    }

    public void cancelClass(int userId, GymClass gymClass)
    {
        try {
            gymClass.cancel();
            System.out.println("Class cancelled successfully!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
