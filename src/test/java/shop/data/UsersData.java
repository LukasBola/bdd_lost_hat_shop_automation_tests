package shop.data;


public enum UsersData {
    CUSTOMER("test_777@test.com", "pass777", "Lukas", "Bolasz"),
    APPLICANT("test_888@test.com", "pass888", "Jan", "Kowalski"),
    EMPLOYEE("test_999@test.com", "pass999", "Bilbo", "Baggins");

    private final String email;
    private final String password;
    private final String name;
    private final String lastname;

    UsersData(String email, String password, String name, String lastname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
