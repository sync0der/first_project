package uz.pdp.project.database;

import java.util.Map;
import java.util.TreeMap;

public class UserProfiles {
    public TreeMap<String, String> users = new TreeMap<>();

    public UserProfiles() {
        users.put("otashboss", "20040815");
        users.put("otashboss2", "08152004");
    }
}
