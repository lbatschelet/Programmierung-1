package woche10;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivitySelector {
    
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity("a1", 5, 9),
            new Activity("a2", 3, 4),
            new Activity("a3", 0, 6),
            new Activity("a4", 1, 2),
            new Activity("a5", 3, 9),
            new Activity("a6", 5, 9),
            new Activity("a7", 6, 7),
            new Activity("a8", 2, 4),
            new Activity("a9", 8, 12),
            new Activity("a10", 2, 14),
            new Activity("a11", 12, 16)
        };
        
        selectActivities(activities);
        
    }

    private static void selectActivities(Activity[] activities) {
        Arrays.sort(activities);
        ArrayList<Activity> selectedActivities = new ArrayList<Activity>();
        selectedActivities.add(activities[0]);
        int currentEndTime = activities[0].getEndTime();

        for (Activity a : activities) {
            if (a.getStartTime() >= currentEndTime) {
                selectedActivities.add(a);
                currentEndTime = a.getEndTime();
            }
        }
        System.out.println(selectedActivities);
    }
}
