package fii.jt.lab9.service;

import fii.jt.lab9.model.Docs;
import fii.jt.lab9.repository.DocsRepository;

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

    public final void add(Docs doc){
        doc.setSerialNumber(serialNumber);
        docsRepository.save(doc);
    }

    public final void update(Docs document){
        docsRepository.update(document);
    }

    public final void delete(Long id){
        docsRepository.delete(id);
    }

    public final List<Docs> getDocs() {
        return docsRepository.getDocs();
    }
}
