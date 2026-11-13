package com.taskflow.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)  //no null values allowed and 100 character limit
    private String title;

    @Column(length = 500) //null values are accepted,500 character limit
    private String description;

    @Enumerated(EnumType.STRING)    //used to declare an java enum
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)    //enum type is string,to avoid default integer numbers assignment 
    @Column(nullable = false)
    private TaskPriority priority;

    private LocalDate dueDate;  //no @column annotation is needed for LocalDate type variable

    @Column(nullable = false, updatable = false)    //updatable used to not include the column in update queries
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    //triggers before entity is stored in database, usually helps in adding default values to null or empty columns
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = TaskStatus.TODO;
        }
        if (this.priority == null) {
            this.priority = TaskPriority.MEDIUM;
        }
    }

    @PreUpdate //triggers right before an update query 
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    //mandatory no-arg constructor for JPA execution 
    public Task() {
    }

    //parameterized constructor for passing values in a single line
    public Task(String title, String description, TaskStatus status, TaskPriority priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }


    //Getters and Setters for all fields
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
