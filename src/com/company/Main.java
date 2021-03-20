package com.company;
class Person {

    private String name;
    private int age;
    private String address;

    public Person() {
        this.name = null;
        this.age = 0;
        this.address = null;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }
}

class Student extends Person {

    private double avgGrade;
    private String favoriteTopic;
    private String coursesEnrolled[];
    private static final int maxCourses = 5;

    public Student (String name, int age, String address, double avgGrade, String favoriteTopic) {
        super(name, age, address); //ne folosim de constructorul clasei parinte

        this.avgGrade = avgGrade;
        this.favoriteTopic = favoriteTopic;
        this.coursesEnrolled = new String[maxCourses];
        this.coursesEnrolled[0] = this.favoriteTopic;
    }

    public double getAvgGrade() {
        return this.avgGrade;
    }

    public String getFavTopic() {
        return this.favoriteTopic;
    }

    public boolean enrollInCourse(String courseName) {
        int index = 0;

        for(String course : coursesEnrolled) {

            if(course != null) {

                if(course.contains(courseName)) {
                    System.out.println("ERROR: Student already enrolled in course " + courseName);
                    return false;
                }
            } else {

                this.coursesEnrolled[index] = courseName;
                System.out.println("Student enrolled in course1 " + courseName);
                return true;
            }
            index++;
        }
        System.out.println("ERROR: Student reached maxed nr of courses!");
        return false;
    }

    public void printStudentCourses() {

        //folosim metoda definita in clasa parinte
        System.out.println("Student's " + super.getName() + " course:");

        for(int i = 0; i < this.coursesEnrolled.length; i++) {
            System.out.println(this.coursesEnrolled[i]);
        }
    }

}


public class Main {
    public static void main(String[] args) {
        Student studONE = new Student("Alex", 26, "Cluj", 8.7, "Java Programming");
        studONE.enrollInCourse("Python Programming");
        studONE.enrollInCourse("C++ Programming");
        studONE.enrollInCourse("IoT Programming");
        studONE.enrollInCourse("Linux");
        studONE.enrollInCourse("AWS");
        studONE.printStudentCourses();
    }
}
