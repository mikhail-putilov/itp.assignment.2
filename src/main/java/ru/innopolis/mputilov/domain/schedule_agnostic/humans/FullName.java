package ru.innopolis.mputilov.domain.schedule_agnostic.humans;

/**
 * Created by mputilov on 25.08.16.
 */
public final class FullName {
    private String firstName;
    private String lastName;
    private String middleName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FullName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + middleName;
    }
}
