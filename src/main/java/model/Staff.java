package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff {
    private String firstName;
    private String lastName;
    private String email;
    private int StaffID;

    public Staff(String firstName, String lastName, String email,int StaffID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.StaffID = StaffID;
    }

    public Staff() {
    }


    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", StaffID=" + StaffID +
                '}';
    }
}
