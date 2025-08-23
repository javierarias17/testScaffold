package co.com.pragma.model.user.gateways;

import co.com.pragma.model.user.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    List<User> getAllUsers();

    User getUserByIdNumber(Long idNumber);

    User editUser(User user);

    void deleteUser(long idNumber);
}
