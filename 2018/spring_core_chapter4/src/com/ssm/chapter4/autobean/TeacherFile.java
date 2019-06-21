package com.ssm.chapter4.autobean;

public class TeacherFile {
	private Teacher teacher;  
    private Student student;  
    public TeacherFile() {  
    }  
    public TeacherFile(Teacher teacher, Student student) {  
        this.teacher = teacher;  
        this.student = student;  
    }  
  
    public Student getStudent() {  
        return this.student;  
    }  
  
    public void setStudent(Student student1) {  
        this.student = student1;  
    }  
  
    public Teacher getTeacher() {  
        return teacher;  
    }  
  
    public void setTeacher(Teacher teacher) {  
        this.teacher = teacher;  
    }  
  
    public void print() {  
        System.out.println("------教师信息------");  
        System.out.println("姓名：" + teacher.getName());  
        System.out.println("年龄：" + teacher.getAge());  
        System.out.println("性别：" + teacher.getSex());  
        System.out.println();  
        System.out.println("------学生信息------");  
        System.out.println("学号：" + student.getID());  
        System.out.println("姓名：" + student.getName());  
        System.out.println("年龄：" + student.getAge());  
        System.out.println("性别：" + student.getSex());  
    }  
  
}
