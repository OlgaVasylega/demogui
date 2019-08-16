package gui.example.demo.controller;

import gui.example.demo.StudentForm;
import gui.example.demo.model.Student;
import gui.example.demo.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Controller
    public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    Logger log= Logger.getLogger(StudentController.class.getName());
        List<Student> students;
        @RequestMapping(value= {"/", "/hello"}, method = RequestMethod.GET)
        String sayHello(Model model) {

            log.info("method say Hello was called");
            String name = "Helga";
            model.addAttribute("name",studentService.getAll());

            return "index";
        }

        @RequestMapping(value= {"/sts"}, method = RequestMethod.GET)
        String showStudents(Model model) {

            model.addAttribute("students",studentService.getAll());

            return "sts";
        }

        @RequestMapping(value= {"/student/delete/{id}"},
                method = RequestMethod.GET)
        String del (Model model, @PathVariable("id") int id){
            studentService.delete(id);
            log.info("Method deleted was called with parm"+id);
//            List<Student> listOfStudentsAfterDelition = students.stream().filter(student -> student.getId() !=id).collect(Collectors.toList());
//            students=listOfStudentsAfterDelition;

            log.info("Deletion was succesful");
            model.addAttribute("students",studentService.getAll());

            return "sts";
        }
    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String addStudent(Model model){

        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
        return "add";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String addStudent(Model model,
                             @ModelAttribute("studentForm") StudentForm studentForm){
        log.info("Try to create a student "+ studentForm.toString());
        if(studentForm.getMark()<128){


        Student newStudent = new Student(studentForm.getName(),studentForm.getGrupa(), (byte) studentForm.getMark());

            log.info("Student servise calledto create a student "+ newStudent.toString());
        studentService.create(newStudent);

        }
        else {log.info("Mark is out of range.Creation failed");}
        model.addAttribute("students", studentService.getAll());
        return "sts";
    }
}
