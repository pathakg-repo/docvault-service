package com.myexample.document.controller;

import com.myexample.document.Model.Document;
import com.myexample.document.Model.ResponseMessage;
import com.myexample.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/docvault")
@CrossOrigin("http://localhost:4200")
public class DocumentController {

    @Autowired
    DocumentService service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            service.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/check/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id){

        return ResponseEntity.ok().body(Document.builder().documentName("test").build());
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocument(){
        return ResponseEntity.ok().body(service.getAllDocument());
    }

    @PostMapping
    public ResponseEntity<?> createDocument(@RequestBody Document document){
        service.saveDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
