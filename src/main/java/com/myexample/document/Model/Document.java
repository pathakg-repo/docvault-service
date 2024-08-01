package com.myexample.document.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    @Column(nullable=false,unique=true)
    public String documentName;
    @Column(nullable=false)
    public String createBy;
    @Column(nullable=false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss.SSSSSS")
    private LocalDateTime createdDate;

}
