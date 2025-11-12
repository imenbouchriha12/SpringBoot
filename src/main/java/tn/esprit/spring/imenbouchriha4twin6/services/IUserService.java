package tn.esprit.spring.imenbouchriha4twin6.services;

import tn.esprit.spring.imenbouchriha4twin6.entities.User;
import java.util.List;

public interface IUserService {
    User addUser(User u);
    List<User> saveUsers(List<User> users);
    User selectUserById(long id);
    List<User> selectAllUsers();
    void deleteUser(User u);
    void deleteAllUsers();
    void deleteUserById(long id);
    long countingUsers();
    boolean verifUserById(long id);
    User selectUserByIdWithOeElse(long id);


}
