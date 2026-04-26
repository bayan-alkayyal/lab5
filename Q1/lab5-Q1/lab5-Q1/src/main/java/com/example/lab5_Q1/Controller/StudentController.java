package com.example.lab5_Q1.Controller;

import com.example.lab5_Q1.ApiResponse.ApiResponse;
import com.example.lab5_Q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse createStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("Student added successfully ! ")  ;
    }

    @GetMapping("/display")
    public ArrayList<Student> displayAllStudents(){
        return students ;
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index , @RequestBody Student student){
        students.set(index , student);
        return new ApiResponse("Student update successfully ! ") ;
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student deleted successfully ! ") ;
    }


    @GetMapping("/honors")
    public ArrayList<String> getStudentsHonors() {

        ArrayList<String> result = new ArrayList<>();

        for (Student s : students) {

            double gpa = s.getGPA();
            String honor;

            if (gpa >= 3.75 && gpa <= 4.00) {
                honor = "First class honor";
            }
            else if (gpa >= 3.50) {
                honor = "Second class honor";
            }
            else if (gpa >= 3.25) {
                honor = "Third class honor";
            }
            else {
                honor = "No honor";
            }

            result.add(s.getName() + " → " + honor);
        }

        return result;
    }


    @GetMapping("/greater-gpa")
    public ArrayList<Student> displayGreaterGPA(){
        double sum = 0 ;
        double average ;

        for(Student s1 : students){
             sum = sum + s1.getGPA();
        }
        average = sum / students.size();

        ArrayList<Student> result = new ArrayList<>();

        for(Student s2 : students){
            if(s2.getGPA() > average){
                result.add(s2);
            }
        }
        return result ;
    }







}
