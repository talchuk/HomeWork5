package team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @JsonProperty("SecondName")
    private String secondName;

    @JsonProperty("Course")
    private String course;

    @JsonProperty("Age")
    private int age;

    public String getSecondName() {
        return secondName;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [SecondName=" + secondName + ", Course=" + course + ", Age=" + age + "]";
    }


}