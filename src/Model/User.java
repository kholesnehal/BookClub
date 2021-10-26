package Model;

public class User {

    private String userName;
    private long mobileNumber;

    public User(String userName, long mobileNumber) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
