package danny.study_app_v1.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String notes;
    private String tag1;
    private String tag2;
    private String tag3;
    private String importance;
    private LocalDateTime lastAttempted;
    private int confidence;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListEntity list;

    // Getters and Setters
}