package fii.jt.lab9.decorator;

import fii.jt.lab9.model.User;
import fii.jt.lab9.interfaces.IUserService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class LoginDecorator implements IUserService {
    @Inject
    @Delegate
    @Any
    IUserService userService;

    public final String login(String username, String password) {
        if (username == null) {
            System.err.println("User cannot be null");
            return null;
        }

        if (password == null) {
            System.err.println("Password cannot be null");
            return null;
        }

        return userService.login(username, password);
    }

    public abstract void addUser(User user);
}
