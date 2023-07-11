package com.aurora.javaweb.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String ID;
    private String Name;

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) && Objects.equals(Name, user.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
