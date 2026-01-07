package com.stream.classwithatleast5student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Client - Classes With at Least 5 Students
 */
class ClientTest {

    @Test
    void testExampleFromLeetCode() {
        // Given: Example from LeetCode problem
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("B", "English"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Biology"),
                new Client.Course("E", "Math"),
                new Client.Course("F", "Computer"),
                new Client.Course("G", "Math"),
                new Client.Course("H", "Math"),
                new Client.Course("I", "Math")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Only Math should be returned (has 6 students)
        assertEquals(1, result.size());
        assertTrue(result.contains("Math"));
        assertFalse(result.contains("English"));
        assertFalse(result.contains("Biology"));
        assertFalse(result.contains("Computer"));
    }

    @Test
    void testMultipleClassesWithAtLeast5Students() {
        // Given: Multiple classes with 5+ students
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("B", "Math"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Math"),
                new Client.Course("E", "Math"),
                new Client.Course("F", "English"),
                new Client.Course("G", "English"),
                new Client.Course("H", "English"),
                new Client.Course("I", "English"),
                new Client.Course("J", "English"),
                new Client.Course("K", "Biology")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Both Math and English should be returned
        assertEquals(2, result.size());
        assertTrue(result.contains("Math"));
        assertTrue(result.contains("English"));
        assertFalse(result.contains("Biology"));
    }

    @Test
    void testExactly5Students() {
        // Given: A class with exactly 5 students
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("B", "Math"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Math"),
                new Client.Course("E", "Math")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Math should be included (exactly 5 students)
        assertEquals(1, result.size());
        assertTrue(result.contains("Math"));
    }

    @Test
    void testNoClassesWithAtLeast5Students() {
        // Given: All classes have less than 5 students
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("B", "Math"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Math"),
                new Client.Course("E", "English"),
                new Client.Course("F", "English"),
                new Client.Course("G", "Biology")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: No classes should be returned
        assertTrue(result.isEmpty());
    }

    @Test
    void testEmptyList() {
        // Given: Empty list of courses
        List<Client.Course> courses = Arrays.asList();

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Empty list should be returned
        assertTrue(result.isEmpty());
    }

    @Test
    void testMoreThan5Students() {
        // Given: A class with more than 5 students
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("B", "Math"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Math"),
                new Client.Course("E", "Math"),
                new Client.Course("F", "Math"),
                new Client.Course("G", "Math"),
                new Client.Course("H", "Math"),
                new Client.Course("I", "Math"),
                new Client.Course("J", "Math")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Math should be included (has 10 students)
        assertEquals(1, result.size());
        assertTrue(result.contains("Math"));
    }

    @Test
    void testDuplicateStudentsInSameClass() {
        // Note: In real SQL scenario, (student, class) is primary key, so duplicates wouldn't exist
        // But for testing purposes, we'll test with potential duplicates
        // Given: Same student enrolled multiple times in same class
        List<Client.Course> courses = Arrays.asList(
                new Client.Course("A", "Math"),
                new Client.Course("A", "Math"), // duplicate
                new Client.Course("B", "Math"),
                new Client.Course("C", "Math"),
                new Client.Course("D", "Math"),
                new Client.Course("E", "Math")
        );

        // When: Finding classes with at least 5 students
        List<String> result = Client.findClassesWithAtLeast5Students(courses);

        // Then: Math should be included (counts all enrollments, including duplicates)
        assertEquals(1, result.size());
        assertTrue(result.contains("Math"));
    }
}

