package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAllstudents() {
        Students studentsPo = new Students();
        List<Map<String, String>> allStudents = studentsPo.getStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/groups")
    public ResponseEntity getRandomGroups() {
        List<List<Map<String, String>>> groups = studentService.getGroups();
        return ResponseEntity.ok(groups);
    }
}
