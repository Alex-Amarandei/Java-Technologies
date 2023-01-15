package fii.jt.lab8.controller;


import fii.jt.lab8.interfaces.IUserService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@Getter
@Setter
public class LoginController implements Serializable {
    private String username;
    private String password;

    @Inject
    private IUserService userService;

    @PostConstruct
    void init() {
    }

    public final void login() throws IOException {
        String role = userService.login(username, password);
        if ("admin".equals(role)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
        } else if ("author".equals(role))
            FacesContext.getCurrentInstance().getExternalContext().redirect("editor.xhtml");
    }
}
