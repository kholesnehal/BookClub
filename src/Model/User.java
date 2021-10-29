package Model;

public class User {

    private String userName;
    private String userAddress;
    private long mobileNumber;

    public User(String userName, String userAddress, long mobileNumber) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
