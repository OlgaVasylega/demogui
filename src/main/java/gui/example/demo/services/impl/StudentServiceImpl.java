package gui.example.demo.services.impl;

import gui.example.demo.controller.StudentController;
import gui.example.demo.model.Student;
import gui.example.demo.repository.StudentRepository;
import gui.example.demo.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentServiceImpl implements IStudentService {
    Logger log= Logger.getLogger(StudentServiceImpl.class.getName());
@Autowired
    StudentRepository studentRepository;
//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Paul McCartney",(byte)1),
//                    new Student(2, "Johne Lenon",(byte) 1),
//                    new Student(3, "Rickey Martin",(byte) 4),
//                    new Student(4, "Till Lindelman",(byte) 2),
//                    new Student(5, "Vera Brezneva",(byte) 3)
//            ));

    @PostConstruct
    void init(){
         }


    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student create(Student student)
    {int lastId= studentRepository
            .findAll()
            .stream()
            .mapToInt(Student::getId)
            .max().getAsInt();
        student.setId(lastId+1);


        log.info("CREATION SUCCES "+ student.toString());
        return studentRepository.save(student);
    }
}
