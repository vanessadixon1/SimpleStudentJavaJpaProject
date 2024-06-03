package com.example.ei;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="Book")
@Table(name="book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "book_name", nullable = false, columnDefinition = "TEXT")
    private String bookName;
    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;
    @ManyToOne()
    @JoinColumn(name="student_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name="student_id_book_fkey"))
    private Student student;

    public Book() {
    }

    public Book(String bookName, LocalDateTime createAt, Student student) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", createAt=" + createAt +
                ", student=" + student +
                '}';
    }

    public Book(String bookName, LocalDateTime createAt) {
        this.bookName = bookName;
        this.createAt = createAt;

    }
}
