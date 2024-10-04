package danny.study_app_v1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<ListEntity> lists;

    // Getters and Setters
}