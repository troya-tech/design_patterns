package com.stream.classwithatleast5student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 596: Classes With at Least 5 Students
 * 
 * Problem: Find all classes that have at least five students.
 * 
 * Solution using Java Stream API:
 * 1. Group courses by class name
 * 2. Count students per class
 * 3. Filter classes with at least 5 students
 * 4. Return the list of class names
 */
public class Client {

    /**
     * Represents a course enrollment record
     */
    public record Course(String student, String className) {
    }

    /**
     * Finds all classes that have at least five students using Stream API
     * 
     * @param courses List of course enrollment records
     * @return List of class names that have at least 5 students
     */
    public static List<String> findClassesWithAtLeast5Students(List<Course> courses) {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::className))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 5)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Example from LeetCode problem
        List<Course> courses = List.of(
                new Course("A", "Math"),
                new Course("B", "English"),
                new Course("C", "Math"),
                new Course("D", "Biology"),
                new Course("E", "Math"),
                new Course("F", "Computer"),
                new Course("G", "Math"),
                new Course("H", "Math"),
                new Course("I", "Math"));

        List<String> result = findClassesWithAtLeast5Students(courses);
        System.out.println("Classes with at least 5 students: " + result);
        // Expected output: [Math]
    }
}
