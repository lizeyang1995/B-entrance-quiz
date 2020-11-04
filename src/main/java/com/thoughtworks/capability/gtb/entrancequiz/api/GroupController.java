package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GroupController {
    private StudentService studentService;

    public GroupController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/groups")
    public ResponseEntity getRandomGroups() {
        List<List<Student>> groups = studentService.getGroups();
        return ResponseEntity.ok(groups);
    }
}
