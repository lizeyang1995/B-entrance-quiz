package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Students studentsVo;
    int GROUP_SIZE = 6;
    public StudentService() {
        studentsVo = new Students();
    }

    public List<List<Map<String, String>>> getGroups() {
        int studentSize = studentsVo.getStudents().size();
        List<Map<String, String>> students = studentsVo.getStudents();
        List<Integer> randomNumber = getRandomNumber(studentSize, 0, studentSize);
        return randomGrouping(studentSize, students, randomNumber);
    }

    private List<List<Map<String, String>>> randomGrouping(int studentSize, List<Map<String, String>> students, List<Integer> randomNumber) {
        int commonSize = studentSize / GROUP_SIZE;
        int restCount = studentSize % GROUP_SIZE;
        List<List<Map<String, String>>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < GROUP_SIZE; i++) {
            List<Map<String, String>> group = new ArrayList<>();
            for (int j = 0; j < commonSize; j++) {
                group.add(students.get(randomNumber.get(count)));
                count++;
            }
            result.add(group);
        }
        for (int i = 0; i < restCount; i++) {
            result.get(i).add(students.get(randomNumber.get(count)));
            count++;
        }
        return result;
    }

    private List<Integer> getRandomNumber(int studentSize, int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while(numbers.size() != studentSize){
            int number = random.nextInt(end-start) + start;
            if(!numbers.contains(number)){
                numbers.add(number);
            }
        }
        return numbers;
    }

    public List<Map<String, String>> addStudent(Student student) {
        Map<String, String> parseStudent = new HashMap<>();
        int studentsSize = studentsVo.getStudents().size();
        parseStudent.put("id", String.valueOf(studentsSize + 1));
        parseStudent.put("name", student.getName());
        studentsVo.addStudent(parseStudent);
        return studentsVo.getStudents();
    }

    public List<Map<String, String>> getAllStudents() {
        return studentsVo.getStudents();
    }
}
