package danny.study_app_v1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<Problem> problems;

    // Getters and Setters
}
