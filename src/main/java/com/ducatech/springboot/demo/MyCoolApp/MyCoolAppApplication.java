package com.ducatech.springboot.demo.MyCoolApp;

import com.ducatech.springboot.demo.MyCoolApp.dao.IStudentDao;
import com.ducatech.springboot.demo.MyCoolApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(IStudentDao studentDao) {
        return  runner -> {
            //createStudent(studentDao);
            //createMultipleStudents(studentDao);
            //readStudent(studentDao);

            //queryForStudents(studentDao);
            //queryForStudentsByLastName(studentDao);

            //updateStudent(studentDao);
            //deleteStudent(studentDao);
        };
    }

    private void deleteStudent(IStudentDao studentDao) {
        int studentId = 4;

        System.out.println("Delete student id: " + studentId);
        studentDao.delete(studentId);
    }

    private void updateStudent(IStudentDao studentDao) {
        int studentId = 1;

        System.out.println("Retrieving student with id: " + studentId);
        Student myStudent = studentDao.findById(studentId);

        System.out.println("Updating student firstName & lastName");
        myStudent.firstName("Silvio");
        myStudent.lastName("Gucci");

        studentDao.update(myStudent);
        System.out.println("Updated student: " + myStudent);

    }

    private void queryForStudentsByLastName(IStudentDao studentDao) {
        List<Student> studentList = studentDao.findByLastName("Duck");

        for (Student std: studentList) {
            System.out.println(std);
        }
    }

    private void queryForStudents(IStudentDao studentDao) {
        List<Student> studentList = studentDao.findAll();

        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    private void readStudent(IStudentDao studentDao) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck","daff.d@hotmail.com");

        System.out.println("Saving student ...");
        studentDao.save(tempStudent);

        int theId = tempStudent.id();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student wit id: " + theId);
        Student myStudent = studentDao.findById(theId);

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(IStudentDao studentDao) {
        System.out.println("Creating 3 new student ...");
        Student tmpStudent1 = new Student("Duc", "Giang", "duc.giang@gamil.com");
        Student tmpStudent2 = new Student("John", "doe", "john.doe@microsoft.com");
        Student tmpStudent3 = new Student("Jack", "Ma", "Jack.Ma@xyz.com");

        List<Student> listOfStudents = Arrays.asList(tmpStudent1, tmpStudent2, tmpStudent3);

        System.out.println("Saving the student ...");
        for (Student student: listOfStudents) {
            studentDao.save(student);

            String result = MessageFormat.format("""
                Student Id: {0}
                Student First Name: {1}
                Student Last Name: {2}
                Student email: {3}
                """,
                    student.id(), student.firstName(), student.lastName(), student.email());
            System.out.println(result);
        }
    }

}
