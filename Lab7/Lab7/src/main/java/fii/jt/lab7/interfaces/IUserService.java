package fii.jt.lab7.interfaces;

import fii.jt.lab7.model.User;

import javax.enterprise.event.Observes;


public interface IUserService {
    String login(String username, String password);

    void addUser(@Observes User user);
}
