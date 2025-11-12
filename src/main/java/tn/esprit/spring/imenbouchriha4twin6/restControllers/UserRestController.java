package tn.esprit.spring.imenbouchriha4twin6.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.imenbouchriha4twin6.entities.User;
import tn.esprit.spring.imenbouchriha4twin6.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRestController {
    private IUserService userService;
    @GetMapping
 public List<User> selectAllUsers(){
     return userService.selectAllUsers();
 }
}
