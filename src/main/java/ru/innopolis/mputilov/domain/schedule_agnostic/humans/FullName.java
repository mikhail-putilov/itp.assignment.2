package ru.innopolis.mputilov.domain.schedule_agnostic.humans;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) &&
                Objects.equals(lastName, fullName.lastName) &&
                Objects.equals(middleName, fullName.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
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
        return (firstName != null ? firstName : "")
                + " " + (lastName != null ? lastName : "")
                + " " + (middleName != null ? middleName : "");
    }
}
