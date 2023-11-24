package woche10;

public class Activity implements Comparable<Activity>{
    private String name;
    private int startTime, endTime;

    public Activity(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.startTime + " - " + this.endTime + ")";
    }

    @Override
    public int compareTo(Activity other) {
        return this.endTime - other.endTime;
    }


}