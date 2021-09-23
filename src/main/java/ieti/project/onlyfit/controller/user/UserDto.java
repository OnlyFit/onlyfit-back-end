package ieti.project.onlyfit.controller.user;

public class UserDto
{
    String name;

    String lastName;

    String email;

    String password;

    String rol;

    String difficult;

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

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }
}
