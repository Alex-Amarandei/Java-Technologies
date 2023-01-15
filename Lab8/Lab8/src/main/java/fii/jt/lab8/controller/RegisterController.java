package fii.jt.lab8.controller;

import fii.jt.lab8.model.User;
import fii.jt.lab8.interfaces.IUserService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named("RegisterController")
@SessionScoped
@Getter
@Setter
public class RegisterController implements Serializable {
    private String username;
    private String password;
    private String role;

    @Inject
    private IUserService userService;

    @PostConstruct
    void init() {
    }

    public final void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("landing.xhtml");
    }

    public final void register() throws IOException {
        userService.addUser(new User(username, password, role));
        redirect();
    }
}
