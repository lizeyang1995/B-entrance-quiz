package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//TODO GTB-综合: - Students.java:7 这个类看起来做了group事情，但是确叫students，不是很表意
public class Students {
    private List<Map<String, String>> students = new ArrayList<>();

    public Students(List<Map<String, String>> students) {
        this.students = students;
    }

    public Students() {
        initStudent();
    }

    public List<Map<String, String>> getStudents() {
        return students;
    }

    public void setStudents(List<Map<String, String>> students) {
        this.students = students;
    }

    //TODO GTB-知识点: - Students.java:27 数据相关的操作，不应该是domain的职责
    public void initStudent() {
        this.students.add(new HashMap<String, String>(){{put("id", "1");put("name", "成吉思汗");}});
        this.students.add(new HashMap<String, String>(){{put("id", "2");put("name", "鲁班七号");}});
        this.students.add(new HashMap<String, String>(){{put("id", "3");put("name", "太乙真人");}});
        this.students.add(new HashMap<String, String>(){{put("id", "4");put("name", "钟无艳");}});
        this.students.add(new HashMap<String, String>(){{put("id", "5");put("name", "花木兰");}});
        this.students.add(new HashMap<String, String>(){{put("id", "6");put("name", "雅典娜");}});
        this.students.add(new HashMap<String, String>(){{put("id", "7");put("name", "芈月");}});
        this.students.add(new HashMap<String, String>(){{put("id", "8");put("name", "白起");}});
        this.students.add(new HashMap<String, String>(){{put("id", "9");put("name", "刘禅");}});
        this.students.add(new HashMap<String, String>(){{put("id", "10");put("name", "庄周");}});
        this.students.add(new HashMap<String, String>(){{put("id", "11");put("name", "马超");}});
        this.students.add(new HashMap<String, String>(){{put("id", "12");put("name", "刘备");}});
        this.students.add(new HashMap<String, String>(){{put("id", "13");put("name", "哪吒");}});
        this.students.add(new HashMap<String, String>(){{put("id", "14");put("name", "大乔");}});
        this.students.add(new HashMap<String, String>(){{put("id", "15");put("name", "蔡文姬");}});
    }

    public void addStudent(Map<String, String> student) {
        this.students.add(student);
    }
}
