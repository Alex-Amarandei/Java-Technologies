package fii.jt.lab7.service;

import fii.jt.lab7.interfaces.IUserService;
import fii.jt.lab7.model.User;
import fii.jt.lab7.repository.UserRepository;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.Serializable;

public class UserService implements IUserService, Serializable {
    @Inject
    private UserRepository userRepository;

    public final String login(String username, String password) {
        try {
            return userRepository.login(username, password);
        } catch (RuntimeException error) {
            return error.getMessage();
        }
    }

    public final void addUser(@Observes User user) {
        userRepository.saveUser(user);
    }
}
