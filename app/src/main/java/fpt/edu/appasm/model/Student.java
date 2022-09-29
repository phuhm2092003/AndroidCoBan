package fpt.edu.appasm.model;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private Date dayBirthday;
    private String idClass;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayBirthday() {
        return dayBirthday;
    }

    public void setDayBirthday(Date dayBirthday) {
        this.dayBirthday = dayBirthday;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public Student(String id, String name, Date dayBirthday, String idClass) {
        this.id = id;
        this.name = name;
        this.dayBirthday = dayBirthday;
        this.idClass = idClass;
    }
}
