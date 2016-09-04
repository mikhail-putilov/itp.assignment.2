package ru.innopolis.mputilov.university;

/**
 * Created by mputilov on 25.08.16.
 */
public class Student {
    private FullName fullName;
    private String studentId;
    private String major;
    // Following fields are instances of String type because we shouldn't hardcode in a program MS1, BS1 and so on...
    // Such abbreviations are not static a can be changed in the future
    private String currentYearOfStuding;
    private String firstYearOfStuding;
    private Group belongsToThisGroup;

    public Student(String studentId, FullName fullName, String major, String currentYearOfStuding, String firstYearOfStuding, Group belongsToThisGroup) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.major = major;
        this.currentYearOfStuding = currentYearOfStuding;
        this.firstYearOfStuding = firstYearOfStuding;
        this.belongsToThisGroup = belongsToThisGroup;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCurrentYearOfStuding() {
        return currentYearOfStuding;
    }

    public void setCurrentYearOfStuding(String currentYearOfStuding) {
        this.currentYearOfStuding = currentYearOfStuding;
    }

    public String getFirstYearOfStuding() {
        return firstYearOfStuding;
    }

    public void setFirstYearOfStuding(String firstYearOfStuding) {
        this.firstYearOfStuding = firstYearOfStuding;
    }

    public Group getBelongsToThisGroup() {
        return belongsToThisGroup;
    }

    public void setBelongsToThisGroup(Group belongsToThisGroup) {
        this.belongsToThisGroup = belongsToThisGroup;
    }

    public String getStudentId() {
        return studentId;
    }
}
