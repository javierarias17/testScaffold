package co.com.pragma.usecase.user.inport;

import co.com.pragma.model.user.User;

import java.util.List;

public interface UserUseCaseInPort {
    public void saveUser(User user);

    public List<User> getAllUsers() ;

    public User getUserByIdNumber(Long idNumber) ;

    public User editUser(User user) ;

    public void deleteUser(Long idNumber) ;
}
