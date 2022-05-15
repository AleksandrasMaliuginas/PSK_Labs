package lt.vu.alma6475.lab1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select a from Student as a"),
        @NamedQuery(name="Student.findByName", query="select a from Student as a WHERE a.name = :name")
})
@Table(name = "Student")
@Getter @Setter
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME", unique = true)
    private String name;

    @ManyToMany(mappedBy = "students")
    List<Subject> subjects = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION", columnDefinition = "integer default 0")
    private Integer version;

    public Student() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student player = (Student) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
