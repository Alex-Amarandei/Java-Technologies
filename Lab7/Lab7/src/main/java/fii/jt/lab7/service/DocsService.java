package fii.jt.lab7.service;

import fii.jt.lab7.model.Docs;
import fii.jt.lab7.repository.DocsRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

public class DocsService implements Serializable {
    @Inject
    @Named("serialNumber")
    private int serialNumber;

    @Inject
    private DocsRepository docsRepository;

    public final void addDoc(String author, String title) {
        docsRepository.saveDoc(new Docs(
                author,
                title,
                serialNumber
        ));
    }

    public final List<Docs> getDocs() {
        return docsRepository.getDocs();
    }
}
