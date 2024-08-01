package com.myexample.document.repository;

import com.myexample.document.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {
    List<Document> findAllByOrderByCreatedDateDesc();
}
