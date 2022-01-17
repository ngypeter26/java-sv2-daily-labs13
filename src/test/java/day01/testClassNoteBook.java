package day01;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testClassNoteBook {
    Student student1 = new Student(1,"Kiss Pista");
    Student student2 = new Student(2,"Kiss 2");
    Student student3 = new Student(3,"Kiss 3");
    Student student4 = new Student(4,"Kiss 4");

    @Test
    void testClassNoteBook(){
        ClassNoteBook cnb = new ClassNoteBook();

        cnb.addStudent(student1);
        cnb.addStudent(student2);
        cnb.addStudent(student3);
        cnb.addStudent(student4);

        Map<Student, List<Integer>> marks = cnb.getMarks();

        cnb.addMark(1,5);
        cnb.addMark(1,2);
        cnb.addMark(1,1);

        System.out.println(marks.get(student1));

        assertEquals(2,marks.get(student1).get(1));
    }

    @Test
    void testAddExistingStudent(){
        ClassNoteBook cnb = new ClassNoteBook();

        cnb.addStudent(student1);
        cnb.addStudent(student2);
        cnb.addStudent(student3);
        IllegalArgumentException iae =  assertThrows(IllegalArgumentException.class, ()-> cnb.addStudent(student1));

        assertEquals("Student already added", iae.getMessage());
    }


}
