package com.example.lab6speedrun;

import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private String Family;
    private String Email;

     User(String name, String family, String email) {
        Name = name;
        Family = family;
        Email = email;
    }
    User(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
