package ieti.project.onlyfit.controller.user;

import ieti.project.onlyfit.repository.document.Information;

public class UserDto
{
    String name;

    String lastName;

    String email;

    String password;

    String rol;

    Information information;

    public UserDto()
    {
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
}
