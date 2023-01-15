package fii.jt.lab7.controller;

import fii.jt.lab7.service.DocsService;
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
    private DocsService docService;

    public final void addDocument() {
        docService.addDoc(title, author);
    }
}
