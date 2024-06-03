package com.example.ei;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentIdCard, Long> {
    StudentIdCard getStudentIdCardById(Long id);

}
