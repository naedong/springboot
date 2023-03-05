package kr.co.e4net.enums;

import java.util.Arrays;
import java.util.HashMap;

public enum Example {

    UNKNOWN(0, "unknown"), ENUM1(1, "enum1"), ENUM2(2, "enum2"), ENUM3(3, "enum3");

    private static HashMap<Integer, Example> enumById = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> enumById.put(e.getId(), e));
    }

    public static Example getById(int id) {
        return enumById.getOrDefault(id, UNKNOWN);
    }

//    public static Example getById(int id) {
//        return enumById.get(id);
//}
    
    private int id;
    private String description;

    private Example(int id, String description) {
        this.id = id;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
    
}