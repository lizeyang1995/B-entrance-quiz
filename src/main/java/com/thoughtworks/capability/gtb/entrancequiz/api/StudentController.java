package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class StudentController {
    @GetMapping("/students")
    public ResponseEntity getAllstudents() {
        return ResponseEntity.ok(null);
    }
}
