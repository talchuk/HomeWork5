package team;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class StudentJSON {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/students.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<Student> students = objectMapper.readValue(fis, typeFactory.constructCollectionType(ArrayList.class, Student.class));

        System.out.println("******************Initial JSON Students list************************");
        for (Student st : students)
            System.out.println(st);

        System.out.println("**********************SORTED Students list*************************");
        sort(students);
        for (Student st : students)
            System.out.println(st);
              
    }
	 
	 public static List<Student> sort(List<Student> studentsToSort) {
        Comparator<Student> studComp = Comparator.comparing(Student::getSecondName)
                .thenComparing(Student::getCourse).thenComparing(Student::getAge);
        Collections.sort(studentsToSort, studComp);
        return studentsToSort;
    }

}
