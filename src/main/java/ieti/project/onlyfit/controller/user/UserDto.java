package ieti.project.onlyfit.controller.user;

import ieti.project.onlyfit.repository.document.Information;

import java.util.List;

public class UserDto
{
    String name;

    String lastName;

    String email;

    String password;

    String rol;

    Information information;

    List<String> routines;

    public UserDto()
    {
    }

    public UserDto(String name, String lastName, String email, String password, String rol, Information information, List<String> routines) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.information = information;
        this.routines = routines;
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRol() { return rol; }

    public Information getInformation() {return information;}

    public void setInformation(Information information) {this.information = information;}

    public List<String> getRoutines() {
        return routines;
    }

    public void setRoutines(List<String> routine) {
        this.routines = routine;
    }
}
