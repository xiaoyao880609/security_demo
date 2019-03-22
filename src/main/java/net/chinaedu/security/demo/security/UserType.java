package net.chinaedu.security.demo.security;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
	ADMIN(0, "管理员"),
	USER(1, "一般用户"),
	OTHER(2, "其他");
 
    private int key;
    private String text;
 
 
    private UserType(int key, String text) {
        this.key = key;
        this.text = text;
    }
 
    public int getKey() {
        return key;
    }
 
    public String getText() {
        return text;
    }
 
    public static Map<Integer, UserType> getUserType() {
        Map<Integer, UserType> userTypeMap = new HashMap<Integer, UserType>();
        for (UserType userType : values()) {
        	userTypeMap.put(userType.key, userType);
        }
        return userTypeMap;
    }
}
