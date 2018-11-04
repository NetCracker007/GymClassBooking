import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInterface {

    public static void main(String args[])
    {
        List<GymCenter> gymCenters = new ArrayList<GymCenter>(){{
            add(new GymCenter("Bellandur", "", 50));
            add(new GymCenter("HSR", "", 50));
        }};
        Map<String, List<GymClass>> gymclasses = new HashMap<String, List<GymClass>>(){{
           put("Bellandur", new ArrayList<GymClass>(){{
               add(new GymClass(){{
                   setId(1);
                   setName("WorkoutA");
                   setClassTimings(new ClassTimings("06:00", "07:00"));
                   setMaxCapacity(2);
               }});
               add(new GymClass(){{
                   setId(2);
                   setName("WorkoutB");
                   setClassTimings(new ClassTimings("07:00", "08:00"));
                   setMaxCapacity(2);
               }});
           }});
           put("HSR", new ArrayList<GymClass>(){{
                add(new GymClass(){{
                    setId(3);
                    setName("WorkoutA");
                    setClassTimings(new ClassTimings("06:00", "07:00"));
                    setMaxCapacity(2);
                }});
                add(new GymClass(){{
                    setId(4);
                    setName("WorkoutB");
                    setClassTimings(new ClassTimings("07:00", "08:00"));
                    setMaxCapacity(2);
                }});
           }});
        }};
        ClassBookingSystem classBookingSystem = new ClassBookingSystem();
        classBookingSystem.setGymCenters(gymCenters);
        classBookingSystem.setListOfClasses(gymclasses);
        boolean isExit = false;
        System.out.println("Available commands:");
        System.out.println("SHOW CENTERS");
        System.out.println("SHOW CLASSES");
        System.out.println("BOOK CLASS");
        System.out.println("CANCEL CLASS");
        System.out.println("EXIT");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!isExit)
        {
            try {
                    String line = bufferedReader.readLine().toLowerCase();
                    if (line.equals("show centers"))
                    {
                        classBookingSystem.displayLocations();
                    }
                    else if (line.equals("show classes"))
                    {
                        System.out.println("Enter location based id:");
                        String locId = bufferedReader.readLine();
                        classBookingSystem.displayLocationBasedClasses(locId);
                    }
                    else if (line.equals("book class"))
                    {
                        System.out.println("Enter location id");
                        String locId = bufferedReader.readLine();
                        List<GymClass> locBasedClasses = classBookingSystem.getListOfClasses().get(locId);
                        System.out.println("Enter class id:");
                        int classId = Integer.parseInt(bufferedReader.readLine());
                        GymClass bookingClass = locBasedClasses.stream().filter(i->i.getId() == classId).findAny().orElse(null);
                        classBookingSystem.bookClass(1, bookingClass);
                    }
                    else if (line.equals("cancel class"))
                    {
                        System.out.println("Enter location id");
                        String locId = bufferedReader.readLine();
                        List<GymClass> locBasedClasses = classBookingSystem.getListOfClasses().get(locId);
                        System.out.println("Enter class id:");
                        int classId = Integer.parseInt(bufferedReader.readLine());
                        GymClass bookingClass = locBasedClasses.stream().filter(i->i.getId() == classId).findAny().orElse(null);
                        classBookingSystem.cancelClass(1, bookingClass);
                    }
                    else if (line.equals("exit"))
                    {
                        isExit = true;
                    }
                    else {
                        System.out.println("Invalid command!");
                    }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
