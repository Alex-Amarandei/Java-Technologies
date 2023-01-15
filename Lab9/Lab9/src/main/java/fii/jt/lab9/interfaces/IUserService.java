package fii.jt.lab9.interfaces;

import fii.jt.lab9.model.User;

import javax.enterprise.event.Observes;


public interface IUserService {
    String login(String username, String password);

    void addUser(@Observes User user);
}
