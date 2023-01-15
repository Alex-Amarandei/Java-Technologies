package fii.jt.lab9.controller;

import fii.jt.lab9.interfaces.IInterceptor;
import fii.jt.lab9.model.Docs;
import fii.jt.lab9.service.DocsService;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("AdminController")
@SessionScoped
@Getter
@Setter
public class AdminController implements Serializable {
    @Inject
    DocsService docService;
    private List<Docs> docList;

    @PostConstruct
    final void init() {
        docList = docService.getDocs();
    }

    @IInterceptor
    public final List<Docs> getDocList() {
        return docList;
    }
}
