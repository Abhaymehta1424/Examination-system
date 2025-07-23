package com.example.ExaminationSystem.service;

import com.example.ExaminationSystem.model.Exam;
import com.example.ExaminationSystem.model.User;
import com.example.ExaminationSystem.repository.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public List<Exam> getExamsByCreator(User user) {
        return examRepository.findByCreatedBy(user);
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }
}


