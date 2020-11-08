package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.repository.GroupsRepository;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private List<Student> students= StudentRepository.students;
    public StudentService() {
        students.add(Student.builder().id(1).name("成吉思汗").build());
        students.add(Student.builder().id(2).name("鲁班七号").build());
        students.add(Student.builder().id(3).name("太乙真人").build());
        students.add(Student.builder().id(4).name("钟无艳").build());
        students.add(Student.builder().id(5).name("花木兰").build());
        students.add(Student.builder().id(6).name("雅典娜").build());
        students.add(Student.builder().id(7).name("芈月").build());
        students.add(Student.builder().id(8).name("白起").build());
        students.add(Student.builder().id(9).name("刘禅").build());
        students.add(Student.builder().id(10).name("庄周").build());
        students.add(Student.builder().id(11).name("马超").build());
        students.add(Student.builder().id(12).name("刘备").build());
        students.add(Student.builder().id(13).name("哪吒").build());
        students.add(Student.builder().id(14).name("大乔").build());
        students.add(Student.builder().id(15).name("蔡文姬").build());
    }

    public List<Student> addStudent(String name) {
        students.add(Student.builder().id(students.size() + 1).name(name).build());
        return students;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
