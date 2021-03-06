package ieti.project.onlyfit.repository.document;

import ieti.project.onlyfit.controller.user.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document
public class User
{
    @Id
    String id;

    String name;

    String lastName;

    @Indexed( unique = true )
    String email;

    String passwordHash;

    List<RoleEnum> roles;

    Date createdAt;

    Information information;


    List<String> routines;

    boolean isPaid;

    public User()
    {
    }

    public User( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
        roles = new ArrayList<>( Collections.singleton( RoleEnum.valueOf(userDto.getRol())) );
        passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        information=userDto.getInformation();
        routines = userDto.getRoutines();
        isPaid= userDto.isPaid();
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public List<String> getRoutines() {
        return routines;
    }

    public void setRoutines(List<String> routines) {
        this.routines = routines;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void update(UserDto userDto ) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.isPaid= userDto.isPaid();
        if ( userDto.getPassword() != null ) {
            this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        }
        this.routines = userDto.getRoutines();
        this.isPaid = userDto.isPaid();
    }
}

