package shop.data;


public class UserReader {

    public static String getUserEmail(String user) {
        return UsersData.valueOf(user).getEmail();
    }

    public static String getUserPassword(String user) {
        return UsersData.valueOf(user).getPassword();
    }

    public static String getUserName(String user) {
        return UsersData.valueOf(user).getName();
    }

    public static String getUserLastname(String user) {
        return UsersData.valueOf(user).getLastname();
    }

    public static String getNameAndLastname(String user) {
        return getUserName(user) + " " + getUserLastname(user);
    }
}
