package day01;

import java.util.*;

public class ClassNoteBook {
    private Map<Student, List<Integer>> marks = new TreeMap<>();

    public void addStudent(Student student){
        if (marks.containsKey(student)){
            throw new IllegalArgumentException("Student already added");
        }
        marks.put(student,new ArrayList<>());
    }
    public void addMark(int id, int mark){
        Student actualStudent = null;
        for (Student s : marks.keySet()){
            if (s.getId() ==id){
                actualStudent = s;
                break;
            }
        }
        List<Integer> actaulMarks = marks.get(actualStudent);
        actaulMarks.add(mark);
        //marks.remove(actualStudent);
        marks.put(actualStudent,actaulMarks);
    }

    public Map<Student, List<Integer>> getMarks() {
        return marks;
    }
}
