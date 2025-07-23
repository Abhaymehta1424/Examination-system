package com.example.ExaminationSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String subject;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Exam() {
    }

    public Exam(Long id, User createdBy, LocalTime scheduledTime, LocalDate scheduledDate, String name, String subject) {
        this.id = id;
        this.createdBy = createdBy;
        this.scheduledTime = scheduledTime;
        this.scheduledDate = scheduledDate;
        this.name = name;
        this.subject = subject;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getSubject() {
        return subject;
    }

    public void setSubject(@NotBlank String subject) {
        this.subject = subject;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
