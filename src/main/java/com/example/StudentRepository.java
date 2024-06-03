package com.example.ei;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT *  FROM student  WHERE age >= 19 AND age < 21", nativeQuery = true)
    List<Student> findStudentsByAgeBetween(Integer minAge, Integer maxAge);
    List<Student> findStudentsByLastNameContaining(String lastName);
    Student findStudentByLastName(String name);
    Student findStudentByLastNameContainingAndAgeBetween(String lastName, Integer minAge, Integer maxAge);
    Student getStudentById(Long id);
    @Transactional
    void deleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query("Delete From Student u Where u.id = 2L ")
    int deleteById(long id);

}
