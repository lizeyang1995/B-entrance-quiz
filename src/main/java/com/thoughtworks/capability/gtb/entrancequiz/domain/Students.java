package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.Map;

public class Students {
    private Map<Integer, String> students;

    public Students(Map<Integer, String> students) {
        this.students = students;
    }

    public Students() {
        initStudent();
    }

    public Map<Integer, String> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, String> students) {
        this.students = students;
    }

    public void initStudent() {
        this.students.put(1, "成吉思汗");
        this.students.put(2, "鲁班七号");
        this.students.put(3, "太乙真人");
        this.students.put(4, "钟无艳");
        this.students.put(5, "花木兰");
        this.students.put(6, "雅典娜");
        this.students.put(7, "芈月");
        this.students.put(8, "白起");
        this.students.put(9, "刘禅");
        this.students.put(10, "庄周");
        this.students.put(11, "马超");
        this.students.put(12, "刘备");
        this.students.put(13, "哪吒");
        this.students.put(14, "大乔");
        this.students.put(15, "蔡文姬");
    }
}
