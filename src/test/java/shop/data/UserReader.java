package shop.data;


public class UserReader {

    private static String userToLog;
    private static String passwordToLog;
    private static String nameAndLastname;

    public static String getUserEmail(String user) {
        switch (user) {
            case "CUSTOMER":
                userToLog = UsersData.CUSTOMER.getEmail();
                break;
            case "APPLICANT":
                userToLog = UsersData.APPLICANT.getEmail();
                break;
        }
        return userToLog;
    }

    public static String getUserPassword(String user) {
        switch (user) {
            case "CUSTOMER":
                passwordToLog = UsersData.CUSTOMER.getPassword();
                break;
            case "APPLICANT":
                passwordToLog = UsersData.APPLICANT.getPassword();
                break;
        }
        return passwordToLog;
    }

    public static String getNameAndLastname(String user) {
        switch (user) {
            case "CUSTOMER":
                nameAndLastname = UsersData.CUSTOMER.getNameAndLastname();
                break;
            case "APPLICANT":
                nameAndLastname = UsersData.APPLICANT.getNameAndLastname();
                break;
        }
        return nameAndLastname;
    }
}
