package fii.jt.lab7.repository;

import fii.jt.lab7.model.Docs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
@Transactional
public class DocsRepository implements Serializable {
    @PersistenceContext(unitName = "Lab7PersistenceUnit")
    EntityManager entityManager;

    public final List<Docs> getDocs() {
        return entityManager.createNamedQuery("Documents.getDocs", Docs.class).getResultList();
    }

    public final void saveDoc(Docs document) {
        entityManager.persist(document);
    }
}
