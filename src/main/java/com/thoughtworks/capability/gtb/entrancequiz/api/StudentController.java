package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class StudentController {
    @GetMapping("/students")
    public ResponseEntity getAllstudents() {
        Students studentsPo = new Students();
        List<Map<String, String>> allStudents = studentsPo.getStudents();
        return ResponseEntity.ok(allStudents);
    }
}
