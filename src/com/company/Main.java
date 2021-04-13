package com.company;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

class Person {

    private String name;
    private int age;
    private String address;
    private String designation;


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

    public Person(String name, int age, String address, String designation) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.designation=designation;
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
    public String getDesignation(){return this.designation;}
}
class Singer extends Person{
    private String bandName;
    public Singer(String name, int age, String address, String designation, String bandName){
        super(name, age, address, designation);
        this.bandName=bandName;
    }
    public String getBandName(){
        return this.bandName;
    }
    public void printSinger(){
        System.out.println("Nume: " + super.getName()+" din "+ super.getAddress()+" fiind "+ super.getDesignation()+" si face parte din trupa: "+ this.bandName);
    }
}

class Dancer extends Person{
    private String groupName;


    public Dancer(String name, int age, String address, String designation, String groupName){
        super(name, age, address, designation);
        this.groupName=groupName;
    }
    public String getGroupName(){
        return this.groupName;
    }
    public void setGroupName(String groupName){
        this.groupName=groupName;
    }
    public void printDancer(){
        System.out.println(getDesignation()+" "+super.getName()+" "+super.getAddress()+" "+this.groupName );
    }
}

class Programmer extends Person{
    private String companyName;

    public Programmer(String name, int age, String address, String designation, String companyName){
        super(name, age, address,designation);
        this.companyName=companyName;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
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
        // afisam maxim 5 cursuri care le poate face un student
        Student studONE = new Student("Alex", 26, "Cluj", 8.7, "Java Programming");
        studONE.enrollInCourse("Python Programming");
        studONE.enrollInCourse("C++ Programming");
        studONE.enrollInCourse("IoT Programming");
        studONE.enrollInCourse("Linux");
        studONE.enrollInCourse("AWS");
        studONE.printStudentCourses();

        //creeam un programator si ii afisam numele orasul si compania
        System.out.println("Programatorul creat este: ");
        Programmer programmer=new Programmer("Cristiana", 30, "Cluj", "Java Developer", "newCompany");
        System.out.println(programmer.getName()+" "+programmer.getAddress()+" "+programmer.getCompanyName());

        //creeam un dansator si ii afisam datele personale
        System.out.println("Dansatorul creat este:");
        Dancer dancer=new Dancer("Diana", 20, "Constanta", "Street Dancer", "DancerGroup");
        dancer.printDancer();

        //creeam un cantaret si afisam datele care le avem despre el
        System.out.println("Cantaretul creat este:");
        Singer singer=new Singer("Ovidiu", 32, "Brasov", "Rock Singer", "RocketBand");
        singer.printSinger();
    }
}

