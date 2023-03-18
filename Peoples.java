public class Peoples {
    private String lastName;
    private String firstName;
    private String secName;
    
    public Peoples(String lastName, String firstName, String secName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secName = secName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }
    
    public String getFullName(){
        return lastName + " " + firstName + " " + secName;  
    }
}
