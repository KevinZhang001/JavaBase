package com.explore.subject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SuperKevin on 2018/1/24.
 * Describe: Join with Array
 */
public class JoinWithArray {
    public static void main(String[] args) {
        JoinWithArray joinClass = new JoinWithArray();
        ArrayList<Student> s = joinClass.getStudents();
        ArrayList<Results> r = joinClass.getRestults();
        joinClass.Join(s, r);
    }

    /**
     *
     * @return
     */
    private ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        Student s = new Student();
        s.setId(1);
        s.setName("张三");
        s.setSex((byte)1);
        students.add(s);

        s = new Student();
        s.setId(2);
        s.setName("李四");
        s.setSex((byte)1);
        students.add(s);

        s = new Student();
        s.setId(3);
        s.setName("王五");
        s.setSex((byte)0);
        students.add(s);

        return students;
    }

    private ArrayList<Results> getRestults(){
        ArrayList<Results> results = new ArrayList<>();
        Results r = new Results();
        r.setStudentId(1);
        r.setSubject("语文");
        r.setResult(85.5);
        results.add(r);

        r = new Results();
        r.setStudentId(1);
        r.setSubject("数学");
        r.setResult(90);
        results.add(r);

        r = new Results();
        r.setStudentId(2);
        r.setSubject("语文");
        r.setResult(90);
        results.add(r);

        r = new Results();
        r.setStudentId(2);
        r.setSubject("数学");
        r.setResult(100);
        results.add(r);

        return results;
    }

    /**
     * print students info and results with join
     * @param s
     * @param r
     */
    private void Join(ArrayList<Student> s, ArrayList<Results> r){
        HashMap<String,ArrayList> tmp = new HashMap<>();
        
    }

    /**
     * Student Entity
     */
    class Student{
        private long id;
        private String name;
        private byte sex;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte getSex() {
            return sex;
        }

        public void setSex(byte sex) {
            this.sex = sex;
        }
    }

    /**
     * 成绩
     */
    class Results{
        private long studentId;
        /**
         * 科目
         */
        private String subject;
        /**
         * 成绩
         */
        private double result;

        public long getStudentId() {
            return studentId;
        }

        public void setStudentId(long studentId) {
            this.studentId = studentId;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public double getResult() {
            return result;
        }

        public void setResult(double result) {
            this.result = result;
        }
    }
}
