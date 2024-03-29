package efia.test0112.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import efia.test0112.entity.Student;
import efia.test0112.service.StudentService;
import efia.test0112.service.NccuWeb3jService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTest {

    @Autowired
    private StudentService studentService;
    private NccuWeb3jService nccuWeb3jService;

    @Test
    public void test01test() {
//    	Web3j web3j = Web3j.build(new HttpService("http://localhost:7545/"));
//    	nccuWeb3jService.printWeb3Version(web3j);
        System.out.println("test3");
    }
    
    @Test
    public void test01addStudent() {
        Student student = new Student("test", 18);
        int row = studentService.addStudent(student);
        System.out.println("row = " + row);
//    	System.out.println("123");
    }
//
//    @Test
//    public void test02addStudents() {
//        Student student = new Student("john", 15);
//        int row = studentService.addStudent(student);
//        student = new Student("mary", 18);
//        row += studentService.addStudent(student);
//        student = new Student("tom", 17);
//        row += studentService.addStudent(student);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test03deleteStudent() {
//        int id = 1;
//        int row = studentService.deleteStudent(id);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test04updateStudent() {
//        int id = 1;
//        Student student = studentService.getStudentById(id);
//        student.setName("mary");
//        student.setAge(18);
//        int row = studentService.updateStudent(student);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test05getStudentById() {
//        int id = 1;
//        Student student = studentService.getStudentById(id);
//        System.out.println(student);
//    }
//
//    @Test
//    public void test06listStudent() {
//        List<Student> students = studentService.listStudent();
//        for (Student student:students) {
//            System.out.println(student);
//        }
//    }

}
