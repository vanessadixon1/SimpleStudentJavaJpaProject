package com.example.ei;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity(name="Enrolment")
@Table(name="enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;
    @ManyToOne
    @MapsId("StudentId")
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Getter
    @Setter
    @Column(
            name = "create_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createAt;

    public Enrolment() {
    }

    public Enrolment(EnrolmentId id, Student student, Course course, LocalDateTime createAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public Enrolment(Student student, Course course, LocalDateTime createAt) {
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrolment enrolment = (Enrolment) o;
        return Objects.equals(id, enrolment.id) && Objects.equals(student, enrolment.student) && Objects.equals(course, enrolment.course) && Objects.equals(createAt, enrolment.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, course, createAt);
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", createAt=" + createAt +
                '}';
    }
}
