package controllers;

import java.util.*;

public class MyForm {
    protected String name;
    protected String password;
    protected String radio;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRadio() {
        return radio;
    }

     public void setRadio(String radio) {
        this.radio = radio;
    }
}