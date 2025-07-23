package com.example.ExaminationSystem.repository;

import com.example.ExaminationSystem.model.Exam;
import com.example.ExaminationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByCreatedBy(User user);
}

