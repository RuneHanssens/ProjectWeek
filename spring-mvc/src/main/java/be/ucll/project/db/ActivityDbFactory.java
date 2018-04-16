package be.ucll.project.db;

public class ActivityDbFactory {
    public static ActivityDb getActivityDb(String type){
        switch (type){
            case "memory": return new ActivityDbInMemory();
            case "JPA": return new ActivityDBFromServer();
            default: return new ActivityDbInMemory();
        }
    }
}
