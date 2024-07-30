package com.example.mvc.test;

import com.example.mvc.controller.StudentController;
import com.example.mvc.model.Student;
import com.example.mvc.view.StudentView;

public class TestMVCPattern {
    public static void main(String[] args) {
 
        Student model = new Student("1", "John Doe", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
