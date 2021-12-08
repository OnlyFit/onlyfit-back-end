package ieti.project.onlyfit.controller.user;

import ieti.project.onlyfit.repository.document.User;
import ieti.project.onlyfit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "/v1/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public List<User> all()
    {
        return userService.all();
    }

    @GetMapping( "/{id}" )
    public User findById( @PathVariable String id )
    {
        return userService.findById( id );
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( userDto ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

    @GetMapping("/users")
    public List<User> allCoaches()
    {
        return userService.allUsers();
    }

    @GetMapping("/user/email")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email)
    }

    @GetMapping("findByName/{name}")
    public ArrayList<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/email")
    @ResponseBody
    public String getRoleByEmail(@RequestParam (name = "emailAddress", value = "emailAddress") String email) {
        return userService.getRoleByEmail(email);
    }
}


