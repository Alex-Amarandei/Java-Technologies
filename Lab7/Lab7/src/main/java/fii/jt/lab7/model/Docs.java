package fii.jt.lab7.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "docs")
@NamedQueries({
        @NamedQuery(name = "Documents.getDocs", query = "select d from Docs d")
})
@Getter
@Setter
@NoArgsConstructor
public class Docs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String author;
    private String title;
    private int serialNumber;

    public Docs(String author, String title, int serialNumber) {
        this.author = author;
        this.title = title;
        this.serialNumber = serialNumber;
    }

}
