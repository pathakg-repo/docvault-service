package com.myexample.document.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentFolder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    @Column(nullable=false,unique=true)
    public String folderName;
    @Column(nullable=false)
    public String createBy;
    @Column(nullable=false)

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss.SSSSSS")
    private LocalDateTime createdDate;

    @Column(nullable=false)
    public String updatedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss.SSSSSS")
    private LocalDateTime updatedDate;

    @Column(nullable=false)
    public String path;
    @ManyToMany
    private Set<DocumentFolder> childFolder;
    // what entities is this entity referenced from?
    @ManyToMany(mappedBy="childFolder")
    private Set<DocumentFolder> parentFolder;
//
//    public DocumentFolder() {
//        childFolder = new HashSet<>();
//    }
}