package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Groups;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private int GROUP_SIZE = 6;
    private List<Student> students= new ArrayList<>();
    private Groups groupsHistory;
    public StudentService() {
        this.groupsHistory = new Groups();
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

    public List<Group> getGroups() {
        int studentSize = students.size();
        List<Integer> randomNumber = getRandomNumber(studentSize, 0, studentSize);
        List<Group> groups = randomGrouping(studentSize, students, randomNumber);
        groupsHistory.getGroupHistory().add(groups);
        return groups;
    }

    private List<Group> randomGrouping(int studentSize, List<Student> students, List<Integer> randomNumber) {
        int commonSize = studentSize / GROUP_SIZE;
        int restCount = studentSize % GROUP_SIZE;
        List<Group> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < GROUP_SIZE; i++) {
            Group group = new Group();
            for (int j = 0; j < commonSize; j++) {
                group.getGroup().add(students.get(randomNumber.get(count)));
                count++;
            }
            result.add(group);
        }
        for (int i = 0; i < restCount; i++) {
            result.get(i).getGroup().add(students.get(randomNumber.get(count)));
            count++;
        }
        return result;
    }

    private List<Integer> getRandomNumber(int studentSize, int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while(numbers.size() != studentSize){
            int number = random.nextInt(end - start) + start;
            if(!numbers.contains(number)){
                numbers.add(number);
            }
        }
        return numbers;
    }

    public List<Student> addStudent(Student student) {
        students.add(Student.builder().id(students.size() + 1).name(student.getName()).build());
        return students;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Group> showGroups() {
        int size = groupsHistory.getGroupHistory().size();
        return groupsHistory.getGroupHistory().get(size - 1);
    }
}
