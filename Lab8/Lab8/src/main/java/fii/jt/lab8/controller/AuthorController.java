package fii.jt.lab8.controller;

import fii.jt.lab8.model.Docs;
import fii.jt.lab8.service.DocsService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("AuthorController")
@SessionScoped
@Getter
@Setter
public class AuthorController implements Serializable {
    private String author;
    private String title;

    @Inject
    private DocsService docsService;

    public final void addDoc() {
        docsService.add(new Docs(title, author, 0));
    }
}
