package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class StudentController {
    private final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> getRandomGroups() {
        return studentService.getGroups();
    }

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getHistoryGroups() {
        return studentService.showGroups();
    }

    @PostMapping("students")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
