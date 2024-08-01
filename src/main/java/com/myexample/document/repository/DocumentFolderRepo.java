package com.myexample.document.repository;

import com.myexample.document.Model.DocumentFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentFolderRepo extends JpaRepository<DocumentFolder, Long> {
}
