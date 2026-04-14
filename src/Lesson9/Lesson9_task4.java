package Lesson9;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lesson9_task4 {

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        // Задача 1: Средний возраст студентов мужского пола
        double avgAgeOfMen = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);

        System.out.println("Средний возраст студентов мужского пола: " + avgAgeOfMen);

        // Задача 2: Студенты, которым грозит повестка (18-27 лет включительно)
        List<Student> conscriptionStudents = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 27)
                .collect(Collectors.toList());

        System.out.println("\nСтуденты, подлежащие призыву (18-27 лет):");
        if (conscriptionStudents.isEmpty()) {
            System.out.println("Нет студентов призывного возраста");
        } else {
            conscriptionStudents.forEach(s ->
                    System.out.println(s.getName() + " (" + s.getAge() + " лет)")
            );
        }
    }

    public enum Gender {
        MAN, WOMAN
    }

    public static class Student {
        private final String name;
        private final int age;
        private final Gender gender;

        public Student(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public Gender getGender() { return gender; }

        @Override
        public String toString() {
            return String.format("{name='%s', age=%d, gender=%s}", name, age, gender);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name) &&
                    gender == student.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
