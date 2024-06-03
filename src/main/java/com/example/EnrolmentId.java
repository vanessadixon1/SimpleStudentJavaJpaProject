package com.example.ei;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolmentId implements Serializable {
    @Column(name="student_id")
    private Long StudentId;
    @Column(name="course_id")
    private Long courseId;

    public EnrolmentId(Long studentId) {
        StudentId = studentId;
    }

    public EnrolmentId() {
    }

    public EnrolmentId(Long studentId, Long courseId) {
        StudentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(StudentId, that.StudentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentId, courseId);
    }

    @Override
    public String toString() {
        return "Environment{" +
                "StudentId=" + StudentId +
                ", courseId=" + courseId +
                '}';
    }

}
