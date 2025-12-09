package my.learn.mireaffjpractice11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
public class Note {

    private Long id;


    private String title;


    private String content;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
}
