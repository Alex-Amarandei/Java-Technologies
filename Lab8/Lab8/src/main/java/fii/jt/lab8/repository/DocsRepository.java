package fii.jt.lab8.repository;

import fii.jt.lab8.model.Docs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
@Transactional
public class DocsRepository implements Serializable {
    @PersistenceContext(unitName = "Lab8PersistenceUnit")
    EntityManager entityManager;

    public final List<Docs> getDocs() {
        return entityManager.createNamedQuery("Docs.getDocs", Docs.class).getResultList();
    }

    public final void save(Docs doc){
        entityManager.persist(doc);
    }

    public final void update(Docs doc){
        entityManager.merge(doc);
    }

    public final void delete(Long id){
        Docs doc = entityManager.find(Docs.class, id);
        if(doc != null){
            entityManager.remove(doc);
        }
    }
}
