package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
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

    //TODO GTB-工程实践: - StudentController.java:28 对group资源的操作，应该放在单独的controller中进行
    //TODO GTB-完成度: - StudentController.java:37 返回的数据结构中缺少组名，或者是放在前端做的？
    //TODO GTB-完成度: - StudentController.java:31 缺少查看分组的api
    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> getRandomGroups() {
        return studentService.getGroups();
    }

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> getHistoryGroups() {
        return studentService.showGroups();
    }

    //TODO GTB-知识点: - StudentController.java:34 资源名应该是复数形式
    //TODO GTB-知识点: - StudentController.java:38 POST请求的状态码应该是201
    //TODO GTB-知识点: - StudentController.java:39 POST的返回结果，应该是成功创建的对象或是id
    //TODO GTB-知识点: - StudentController.java:40 了解下@ResponseStatus
    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
