package lt.vu.alma6475.lab1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Tutor.findAll", query = "select a from Tutor as a")
})
@Table(name = "Tutor")
@Getter @Setter
public class Tutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "tutor")
    private List<Subject> subjects = new ArrayList<>();

    public Tutor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(id, tutor.id) &&
                Objects.equals(name, tutor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
