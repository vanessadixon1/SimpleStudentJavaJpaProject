package com.example.ei;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "Student")
@Table(name = "student",
                uniqueConstraints = {
                    @UniqueConstraint(name = "unique_last_name", columnNames = "last_name")
                })
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id", updatable = false)
    @Getter
    @Setter
    private Long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    @Getter
    @Setter
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    @Getter
    @Setter
    private String lastName;
    @Column(name = "age", nullable = false)
    @Getter
    @Setter
    private Integer age;

    @OneToOne()
    private StudentIdCard studentIdCard;
    @Getter
    @Setter
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Book> books = new ArrayList<>();
    @Getter
    @Setter
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "student")
    private List<Enrolment> enrolments = new ArrayList<>();


    public Student() {
    }

    public void addBook(Book book) {
        if(!books.contains(book)) {
            books.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if(this.books.contains(book)) {
            books.remove(book);
            book.setStudent(null);
        }
    }

    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    public void addEnrolment(Enrolment enrolment) {
        if(!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }
    public void removeEnrolment(Enrolment enrolment) {
        if(this.enrolments.contains(enrolment)) {
            enrolments.remove(enrolment);
        }
    }
}
