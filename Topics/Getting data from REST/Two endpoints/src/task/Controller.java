package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

class Student {
 
    public int id;
    public String name;

    public Student (){

    }

    public Student (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@RestController
public class Controller {
    
    List<Student> studentList = new ArrayList<>();
    
    
    
    public void createRandomStudent() {
       Student alice = new Student(84, "Alice");
       Student kate = new Student(99, "kate");
       Student someone = new Student(55, "Someone");
       studentList.add(alice);
       studentList.add(kate);
       studentList.add(someone);
   }
    
    @GetMapping("/students")
    public List<Student> getStudentsController() {
        createRandomStudent();
        return studentList;
    }

    @GetMapping("/students/{id}")
    public Student getStudentsController(@PathVariable("id") int id) {
        for(Student student : studentList) {
            if(student.id == id){
                return student;
            } 
        }
        return null;
    }
}
