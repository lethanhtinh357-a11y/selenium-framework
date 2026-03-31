package utils;

public class ConfigReader {

    public static String getUsername() {
        String username = System.getenv("SAUCEDEMO_USERNAME");
        return (username != null) ? username : "default_user";
    }

    public static String getPassword() {
        String password = System.getenv("SAUCEDEMO_PASSWORD");
        return (password != null) ? password : "default_pass";
    }
}