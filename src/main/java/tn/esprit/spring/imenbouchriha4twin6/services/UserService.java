package tn.esprit.spring.imenbouchriha4twin6.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.imenbouchriha4twin6.entities.User;
import tn.esprit.spring.imenbouchriha4twin6.repositories.SexeRepository;
import tn.esprit.spring.imenbouchriha4twin6.repositories.UserRepositry;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

UserRepositry userRepositry;

    @Override
    public User addUser(User u) {
        return userRepositry.save(u);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return List.of();
    }

    @Override
    public User selectUserById(long id) {
      //  return userRepositry.findById(id).orElse(null);
        return userRepositry.findById(id).get();

    }

    @Override
    public User selectUserByIdWithOeElse(long id){
        User u = User.builder().nom("foulen").prenom("Ben Foulen").build();
        return userRepositry.findById(id).orElse(u);
    }
    @Override
    public List<User> selectAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(User u) {
      userRepositry.delete(u);
    }

    @Override
    public void deleteAllUsers() {
      userRepositry.deleteAll();
    }

    @Override
    public void deleteUserById(long id) {
    }

    @Override
    public long countingUsers() {
        return 0;
    }

    @Override
    public boolean verifUserById(long id) {
        return false;
    }
}
