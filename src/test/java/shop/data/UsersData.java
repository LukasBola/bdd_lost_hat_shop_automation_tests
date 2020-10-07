package shop.data;


public enum UsersData {
    CUSTOMER("test_777@test.com", "pass777", "Lukas Bolasz"),
    APPLICANT("test_888@test.com", "pass888", "Lukas Bolasz");

    private final String email;
    private final String password;
    private final String nameAndLastname;

    UsersData(String email, String password, String nameAndLastname) {
        this.email = email;
        this.password = password;
        this.nameAndLastname = nameAndLastname;
    }

    public String getNameAndLastname() {
        return nameAndLastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
