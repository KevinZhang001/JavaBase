package com.explore.subject;

import java.util.*;

/**
 * Created by SuperKevin on 2018/1/24.
 * Describe: Join with Array
 */
public class JoinWithArray {
    public static void main(String[] args) {
        JoinWithArray joinClass = new JoinWithArray();
        ArrayList<Student> s = joinClass.getStudents();
        ArrayList<Results> r = joinClass.getRestults();
        long startTime,endTime;
        startTime = System.currentTimeMillis();
        joinClass.Join(s, r);
        endTime = System.currentTimeMillis();
        System.out.println("Join耗时:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        joinClass.Join1(s, r);
        endTime = System.currentTimeMillis();
        System.out.println("Join1耗时:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        joinClass.Join2(s,r);
        endTime = System.currentTimeMillis();
        System.out.println("Join2耗时:" + (endTime - startTime));
    }

    /**
     *
     * @return
     */
    private ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        int id =1;
        Student s = new Student();
        s.setId(1);
        s.setName("张三");
        s.setSex((byte)1);
        students.add(s);

        for (int i = 0; i < 100; i++) {
            id++;
            s = new Student();
            s.setId(id);
            s.setName("李四" + i);
            s.setSex((byte)1);
            students.add(s);
        }

        for (int i = 0; i < 100; i++) {
            id++;
            s = new Student();
            s.setId(id);
            s.setName("王五" + i);
            s.setSex((byte) 0);
            students.add(s);
        }

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

        int id =1;
        for (int i = 0; i < 200; i++) {
            id++;
            r = new Results();
            r.setStudentId(id);
            r.setSubject("语文");
            r.setResult(90);
            results.add(r);

            r = new Results();
            r.setStudentId(id);
            r.setSubject("数学");
            r.setResult(100);
            results.add(r);
        }

        return results;
    }

    /**
     * print students info and results with join
     * @param s
     * @param r
     */
    private void Join(ArrayList<Student> s, ArrayList<Results> r){
        HashMap<Long,Object[]> tmp = new HashMap<>();
        for (int i = 0; i < s.size(); i++) {
            Long studentId = s.get(i).id;
            if(!tmp.containsKey(studentId)){
                Object[] o = new Object[2];
                ArrayList<Student> sl = new ArrayList<>();
                sl.add(s.get(i));
                o[0] = sl;
                tmp.put(studentId, o);
                continue;
            }

            ((ArrayList<Student>)tmp.get(studentId)[0]).add(s.get(i));
        }

        for (int i = 0; i < r.size(); i++) {
            Long studentId = r.get(i).getStudentId();
            if(tmp.containsKey(studentId)){
                if(tmp.get(studentId).length > 1 && tmp.get(studentId)[1] != null){
                    ((ArrayList<Results>)tmp.get(studentId)[1]).add(r.get(i));
                    continue;
                }
                ArrayList<Results> rl = new ArrayList<>();
                rl.add(r.get(i));
                tmp.get(studentId)[1] = rl;
            }
        }

        for(Object[] o : tmp.values()){
            if(o.length == 1 || o[1] == null) continue;

            ArrayList<Student> sl = (ArrayList<Student>)o[0];
            ArrayList<Results> rl = (ArrayList<Results>)o[1];

            for (int i = 0; i < sl.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(sl.get(i).getId());
                sb.append(" ");
                sb.append(sl.get(i).getName());
                sb.append(" ");
                for (int j = 0; j < rl.size(); j++) {
                    StringBuilder rb = new StringBuilder();
                    rb.append(rl.get(j).getSubject());
                    rb.append(" ");
                    rb.append(rl.get(j).getResult());
                    //System.out.println(sb.toString() + rb.toString());
                }
            }
        }
    }

    /**
     * Join 优化
     * @param s
     * @param r
     */
    private void Join1(ArrayList<Student> s, ArrayList<Results> r){
        HashMap<Long,List<Student>> sl = new HashMap<>();
        HashMap<Long,List<Results>> rl = new HashMap<>();
        for (int i = 0; i < s.size(); i++) {
            Student sID = s.get(i);
            if(sl.containsKey(sID.getId())){
                sl.get(sID.getId()).add(sID);
                continue;
            }
            List<Student> tmpSl = new ArrayList<>();
            tmpSl.add(sID);
            sl.put(sID.getId(),tmpSl);
        }

        for (int i = 0; i < r.size(); i++) {
            Results sID = r.get(i);
            if(rl.containsKey(sID.getStudentId())){
                rl.get(sID.getStudentId()).add(sID);
                continue;
            }
            List<Results> tmpSl = new ArrayList<>();
            tmpSl.add(sID);
            rl.put(sID.getStudentId(),tmpSl);
        }

        for(Long id: sl.keySet()){
            if(!rl.containsKey(id)) continue;
            for (int i = 0; i < sl.get(id).size(); i++) {
                Student st = sl.get(id).get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(st.getId());
                sb.append(" ");
                sb.append(st.getName());
                sb.append(" ");
                for (int j = 0; j < rl.get(id).size(); j++) {
                    Results rs = rl.get(id).get(i);
                    StringBuilder rb = new StringBuilder();
                    rb.append(rs.getSubject());
                    rb.append(" ");
                    rb.append(rs.getResult());
                    //System.out.println(sb.toString() + rb.toString());
                }
            }
        }

    }

    /**
     * print students info and results with join m*n
     * @param s
     * @param r
     */
    private void Join2(ArrayList<Student> s, ArrayList<Results> r){
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j <r.size(); j++) {
                if(s.get(i).getId() == r.get(j).getStudentId()){
                    Student student = s.get(i);
                    Results results = r.get(j);
                    StringBuilder sb = new StringBuilder();
                    sb.append(student.getId());
                    sb.append(" ");
                    sb.append(student.getName());
                    sb.append(" ");
                    sb.append(results.getSubject());
                    sb.append(" ");
                    sb.append(results.getResult());
                    //System.out.println(sb.toString());
                }
            }
        }
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
