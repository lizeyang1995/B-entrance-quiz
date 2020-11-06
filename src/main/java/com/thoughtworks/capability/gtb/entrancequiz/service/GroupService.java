package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.GroupsRepository;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GroupService {
    private int GROUP_SIZE = GroupsRepository.GROUP_SIZE;
    private List<Student> students= StudentRepository.students;

    public List<Group> getGroups() {
        int studentSize = students.size();
        List<Integer> randomNumber = getRandomNumber(studentSize, 0, studentSize);
        List<Group> groups = randomGrouping(studentSize, students, randomNumber);
        GroupsRepository.groupsHistory.add(groups);
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

    public List<Group> showGroups() {
        int size = GroupsRepository.groupsHistory.size();
        if (size == 0) {
            return null;
        }
        return GroupsRepository.groupsHistory.get(size - 1);
    }
}
