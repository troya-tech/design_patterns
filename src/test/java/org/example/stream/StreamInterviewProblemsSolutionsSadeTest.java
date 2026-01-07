package org.example.stream;

import com.stream.StreamInterviewProblemsSolutionsSade;
import com.stream.model.Employee;
import com.stream.model.LineItem;
import com.stream.model.Order;
import com.stream.model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamInterviewProblemsSolutionsSadeTest {

    /* =========================
       EASY (1–10)
       ========================= */

    @Test
    void testAdultNames() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC"),
                new Person("Diana", 30, "LA")
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.adultNames(people);
        assertEquals(List.of("Alice", "Charlie", "Diana"), result);
    }

    @Test
    void testAdultNames_EmptyList() {
        List<String> result = StreamInterviewProblemsSolutionsSade.adultNames(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void testAdultNames_AllMinors() {
        List<Person> people = List.of(
                new Person("Alice", 17, "NYC"),
                new Person("Bob", 16, "LA")
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.adultNames(people);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNormalize() {
        // Task: trim, drop empty, uppercase
        // Example: [" a ", " ", "b"] -> ["A","B"]
        List<String> input = List.of(" a ", " ", "b");
        List<String> result = StreamInterviewProblemsSolutionsSade.normalize(input);
        assertEquals(List.of("A", "B"), result);
    }

    @Test
    void testNormalize_WithMoreExamples() {
        List<String> input = List.of("  hello  ", "  world  ", "  ", "test", "  JAVA  ");
        List<String> result = StreamInterviewProblemsSolutionsSade.normalize(input);
        // After trim: ["hello", "world", "", "test", "JAVA"]
        // After drop empty: ["hello", "world", "test", "JAVA"]
        // After uppercase: ["HELLO", "WORLD", "TEST", "JAVA"]
        assertEquals(List.of("HELLO", "WORLD", "TEST", "JAVA"), result);
    }

    @Test
    void testNormalize_AllEmpty() {
        List<String> input = List.of("  ", " ", "");
        List<String> result = StreamInterviewProblemsSolutionsSade.normalize(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNormalize_EmptyList() {
        List<String> result = StreamInterviewProblemsSolutionsSade.normalize(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountPrefix() {
        List<String> words = List.of("apple", "application", "banana", "app", "apricot");
        long result = StreamInterviewProblemsSolutionsSade.countPrefix(words, "app");
        assertEquals(4, result);
    }

    @Test
    void testCountPrefix_NoMatches() {
        List<String> words = List.of("banana", "cherry", "date");
        long result = StreamInterviewProblemsSolutionsSade.countPrefix(words, "app");
        assertEquals(0, result);
    }

    @Test
    void testCountPrefix_EmptyPrefix() {
        List<String> words = List.of("apple", "banana", "application");
        long result = StreamInterviewProblemsSolutionsSade.countPrefix(words, "");
        assertEquals(3, result); // All strings start with empty prefix
    }

    @Test
    void testSumSquares() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int result = StreamInterviewProblemsSolutionsSade.sumSquares(nums);
        assertEquals(55, result); // 1+4+9+16+25 = 55
    }

    @Test
    void testSumSquares_EmptyList() {
        int result = StreamInterviewProblemsSolutionsSade.sumSquares(List.of());
        assertEquals(0, result);
    }

    @Test
    void testFirstEven() {
        List<Integer> nums = List.of(1, 3, 5, 2, 4, 6);
        Optional<Integer> result = StreamInterviewProblemsSolutionsSade.firstEven(nums);
        assertTrue(result.isPresent());
        assertEquals(2, result.get());
    }

    @Test
    void testFirstEven_NoEvens() {
        List<Integer> nums = List.of(1, 3, 5, 7);
        Optional<Integer> result = StreamInterviewProblemsSolutionsSade.firstEven(nums);
        assertFalse(result.isPresent());
    }

    @Test
    void testDistinctCitiesSorted() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC"),
                new Person("Diana", 30, "Boston")
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.distinctCitiesSorted(people);
        assertEquals(List.of("Boston", "LA", "NYC"), result);
    }

    @Test
    void testDistinctCitiesSorted_SingleCity() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "NYC")
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.distinctCitiesSorted(people);
        assertEquals(List.of("NYC"), result);
    }

    @Test
    void testJoinNames() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC")
        );
        String result = StreamInterviewProblemsSolutionsSade.joinNames(people);
        assertEquals("Alice,Bob,Charlie", result);
    }

    @Test
    void testJoinNames_EmptyList() {
        String result = StreamInterviewProblemsSolutionsSade.joinNames(List.of());
        assertEquals("", result);
    }

    @Test
    void testPartitionAdults() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC"),
                new Person("Diana", 15, "Boston")
        );
        Map<Boolean, List<Person>> result = StreamInterviewProblemsSolutionsSade.partitionAdults(people);
        assertTrue(result.containsKey(true));
        assertTrue(result.containsKey(false));
        assertEquals(2, result.get(true).size());
        assertEquals(2, result.get(false).size());
    }

    @Test
    void testTopN() {
        List<Integer> nums = List.of(5, 2, 8, 1, 9, 3);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.topN(nums, 3);
        assertEquals(List.of(9, 8, 5), result);
    }

    @Test
    void testTopN_EmptyList() {
        List<Integer> result = StreamInterviewProblemsSolutionsSade.topN(List.of(), 3);
        assertTrue(result.isEmpty());
    }

    @Test
    void testTopN_NLargerThanList() {
        List<Integer> nums = List.of(5, 2, 8);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.topN(nums, 10);
        assertEquals(3, result.size());
        assertEquals(List.of(8, 5, 2), result);
    }

    @Test
    void testAnyInvalidEmail() {
        List<String> emails = List.of("valid@example.com", "invalid", "another@test.co.uk");
        boolean result = StreamInterviewProblemsSolutionsSade.anyInvalidEmail(emails);
        assertTrue(result);
    }

    @Test
    void testAnyInvalidEmail_AllValid() {
        List<String> emails = List.of("valid@example.com", "another@test.co.uk");
        boolean result = StreamInterviewProblemsSolutionsSade.anyInvalidEmail(emails);
        assertFalse(result);
    }


    /* =========================
       MEDIUM (11–22)
       ========================= */

    @Test
    void testGroupByCity() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC"),
                new Person("Diana", 30, "LA")
        );
        Map<String, List<Person>> result = StreamInterviewProblemsSolutionsSade.groupByCity(people);
        assertEquals(2, result.size());
        assertEquals(2, result.get("NYC").size());
        assertEquals(2, result.get("LA").size());
    }

    @Test
    void testCountByCity() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC"),
                new Person("Diana", 30, "LA")
        );
        Map<String, Long> result = StreamInterviewProblemsSolutionsSade.countByCity(people);
        assertEquals(2, result.get("NYC"));
        assertEquals(2, result.get("LA"));
    }

    @Test
    void testAvgAgeByCity() {
        List<Person> people = List.of(
                new Person("Alice", 20, "NYC"),
                new Person("Bob", 30, "NYC"),
                new Person("Charlie", 25, "LA")
        );
        Map<String, Double> result = StreamInterviewProblemsSolutionsSade.avgAgeByCity(people);
        assertEquals(25.0, result.get("NYC"), 0.01);
        assertEquals(25.0, result.get("LA"), 0.01);
    }

    @Test
    void testNamesByCity() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Charlie", 18, "NYC")
        );
        Map<String, List<String>> result = StreamInterviewProblemsSolutionsSade.namesByCity(people);
        assertEquals(List.of("Alice", "Charlie"), result.get("NYC"));
        assertEquals(List.of("Bob"), result.get("LA"));
    }

    @Test
    void testUniqueNamesByCity() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Alice", 30, "NYC"),
                new Person("Bob", 17, "LA")
        );
        Map<String, Set<String>> result = StreamInterviewProblemsSolutionsSade.uniqueNamesByCity(people);
        assertEquals(Set.of("Alice"), result.get("NYC"));
        assertEquals(Set.of("Bob"), result.get("LA"));
    }

    @Test
    void testFlattenDistinctSorted() {
        List<List<Integer>> lists = List.of(
                List.of(3, 1, 2),
                List.of(2, 4, 3),
                List.of(5, 1)
        );
        List<Integer> result = StreamInterviewProblemsSolutionsSade.flattenDistinctSorted(lists);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void testFlattenDistinctSorted_EmptyLists() {
        List<List<Integer>> lists = List.of(
                List.of(),
                List.of(1, 2),
                List.of()
        );
        List<Integer> result = StreamInterviewProblemsSolutionsSade.flattenDistinctSorted(lists);
        assertEquals(List.of(1, 2), result);
    }

    @Test
    void testTotalPaid() {
        List<Order> orders = List.of(
                new Order("1", "cust1", 100.0, "PAID"),
                new Order("2", "cust2", 200.0, "PENDING"),
                new Order("3", "cust1", 150.0, "PAID")
        );
        double result = StreamInterviewProblemsSolutionsSade.totalPaid(orders);
        assertEquals(250.0, result, 0.01);
    }

    @Test
    void testTotalPaid_NoPaidOrders() {
        List<Order> orders = List.of(
                new Order("1", "cust1", 100.0, "PENDING"),
                new Order("2", "cust2", 200.0, "CANCELLED")
        );
        double result = StreamInterviewProblemsSolutionsSade.totalPaid(orders);
        assertEquals(0.0, result, 0.01);
    }

    @Test
    void testTopEarnerByDept() {
        List<Employee> emps = List.of(
                new Employee("Alice", "IT", 100000),
                new Employee("Bob", "IT", 120000),
                new Employee("Charlie", "HR", 80000)
        );
        Map<String, Optional<Employee>> result = StreamInterviewProblemsSolutionsSade.topEarnerByDept(emps);
        assertTrue(result.get("IT").isPresent());
        assertEquals("Bob", result.get("IT").get().name());
        assertTrue(result.get("HR").isPresent());
        assertEquals("Charlie", result.get("HR").get().name());
    }

    @Test
    void testMaxSalaryByDept() {
        List<Employee> emps = List.of(
                new Employee("Alice", "IT", 100000),
                new Employee("Bob", "IT", 120000),
                new Employee("Charlie", "HR", 80000)
        );
        Map<String, Integer> result = StreamInterviewProblemsSolutionsSade.maxSalaryByDept(emps);
        assertEquals(120000, result.get("IT"));
        assertEquals(80000, result.get("HR"));
    }

    @Test
    void testSecondHighestDistinct() {
        List<Integer> nums = List.of(5, 2, 8, 1, 9, 3, 9, 8);
        OptionalInt result = StreamInterviewProblemsSolutionsSade.secondHighestDistinct(nums);
        assertTrue(result.isPresent());
        assertEquals(8, result.getAsInt());
    }

    @Test
    void testSecondHighestDistinct_OnlyOneDistinct() {
        List<Integer> nums = List.of(5, 5, 5);
        OptionalInt result = StreamInterviewProblemsSolutionsSade.secondHighestDistinct(nums);
        assertFalse(result.isPresent());
    }

    @Test
    void testSecondHighestDistinct_OnlyTwoDistinct() {
        List<Integer> nums = List.of(5, 3, 5, 3);
        OptionalInt result = StreamInterviewProblemsSolutionsSade.secondHighestDistinct(nums);
        assertTrue(result.isPresent());
        assertEquals(3, result.getAsInt());
    }

    @Test
    void testMostFrequentWord() {
        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana", "apple");
        Optional<String> result = StreamInterviewProblemsSolutionsSade.mostFrequentWord(words);
        assertTrue(result.isPresent());
        assertEquals("apple", result.get());
    }

    @Test
    void testMostFrequentWord_Tie() {
        // When tied, should return lexicographically smallest
        List<String> words = List.of("apple", "banana", "apple", "banana");
        Optional<String> result = StreamInterviewProblemsSolutionsSade.mostFrequentWord(words);
        assertTrue(result.isPresent());
        // Should be "apple" (lexicographically smaller than "banana")
        assertEquals("apple", result.get());
    }

    @Test
    void testProductNonZero() {
        List<Integer> nums = List.of(2, 3, 4, 0, 5);
        int result = StreamInterviewProblemsSolutionsSade.productNonZero(nums);
        assertEquals(120, result); // 2*3*4*5 = 120
    }

    @Test
    void testProductNonZero_AllZeros() {
        List<Integer> nums = List.of(0, 0, 0);
        int result = StreamInterviewProblemsSolutionsSade.productNonZero(nums);
        assertEquals(1, result);
    }

    @Test
    void testProductNonZero_EmptyList() {
        int result = StreamInterviewProblemsSolutionsSade.productNonZero(List.of());
        assertEquals(1, result);
    }


    /* =========================
       MEDIUM+ (23–26)
       ========================= */

    @Test
    void testTotalSpentByCustomer() {
        List<Order> orders = List.of(
                new Order("1", "cust1", 100.0, "PAID"),
                new Order("2", "cust1", 200.0, "PAID"),
                new Order("3", "cust2", 150.0, "PAID"),
                new Order("4", "cust1", 50.0, "PENDING")
        );
        Map<String, Double> result = StreamInterviewProblemsSolutionsSade.totalSpentByCustomer(orders);
        assertEquals(300.0, result.get("cust1"), 0.01);
        assertEquals(150.0, result.get("cust2"), 0.01);
    }

    @Test
    void testOrderTotalFromItems() {
        List<LineItem> items = List.of(
                new LineItem("order1", "sku1", 2, 10.0),
                new LineItem("order1", "sku2", 3, 5.0),
                new LineItem("order2", "sku1", 1, 10.0)
        );
        Map<String, Double> result = StreamInterviewProblemsSolutionsSade.orderTotalFromItems(items);
        assertEquals(35.0, result.get("order1"), 0.01); // 2*10 + 3*5 = 35
        assertEquals(10.0, result.get("order2"), 0.01); // 1*10 = 10
    }

    @Test
    void testTotalQtyByCustomerPaid() {
        List<Order> orders = List.of(
                new Order("order1", "cust1", 100.0, "PAID"),
                new Order("order2", "cust1", 200.0, "PAID"),
                new Order("order3", "cust2", 150.0, "PENDING")
        );
        List<LineItem> items = List.of(
                new LineItem("order1", "sku1", 5, 10.0),
                new LineItem("order1", "sku2", 3, 5.0),
                new LineItem("order2", "sku1", 2, 10.0),
                new LineItem("order3", "sku1", 10, 10.0)
        );
        Map<String, Integer> result = StreamInterviewProblemsSolutionsSade.totalQtyByCustomerPaid(orders, items);
        assertEquals(10, result.get("cust1")); // 5+3+2 = 10
        assertNull(result.get("cust2")); // order3 is not PAID
    }

    @Test
    void testTop3SkusByRevenue() {
        List<LineItem> items = List.of(
                new LineItem("order1", "sku1", 10, 100.0), // 1000
                new LineItem("order2", "sku2", 5, 150.0),  // 750
                new LineItem("order3", "sku3", 8, 80.0),   // 640
                new LineItem("order4", "sku4", 3, 200.0),  // 600
                new LineItem("order5", "sku1", 2, 100.0)  // 200 (sku1 total: 1200)
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.top3SkusByRevenue(items);
        assertEquals(3, result.size());
        assertEquals("sku1", result.get(0)); // 1200
        assertEquals("sku2", result.get(1)); // 750
        assertEquals("sku3", result.get(2)); // 640
    }


    /* =========================
       HARD (27–30)
       ========================= */

    @Test
    void testDistinctByNameKeepFirst() {
        List<Person> people = List.of(
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 17, "LA"),
                new Person("Alice", 30, "Boston"), // duplicate name
                new Person("Charlie", 18, "NYC")
        );
        List<Person> result = StreamInterviewProblemsSolutionsSade.distinctByNameKeepFirst(people);
        assertEquals(3, result.size());
        assertEquals("Alice", result.get(0).name());
        assertEquals(25, result.get(0).age()); // First Alice kept
        assertEquals("Bob", result.get(1).name());
        assertEquals("Charlie", result.get(2).name());
    }

    @Test
    void testGroupCitySorted() {
        List<Person> people = List.of(
                new Person("Charlie", 18, "NYC"),
                new Person("Alice", 25, "NYC"),
                new Person("Bob", 25, "NYC"),
                new Person("Diana", 20, "LA")
        );
        Map<String, List<Person>> result = StreamInterviewProblemsSolutionsSade.groupCitySorted(people);
        
        List<Person> nycPeople = result.get("NYC");
        assertEquals(3, nycPeople.size());
        assertEquals("Charlie", nycPeople.get(0).name()); // age 18
        assertEquals(25, nycPeople.get(1).age()); // age 25
        assertEquals(25, nycPeople.get(2).age()); // age 25
        
        List<Person> laPeople = result.get("LA");
        assertEquals(1, laPeople.size());
        assertEquals("Diana", laPeople.get(0).name());
    }

    @Test
    void testWindowSums() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.windowSums(nums, 3);
        assertEquals(List.of(6, 9, 12), result); // [1+2+3, 2+3+4, 3+4+5]
    }

    @Test
    void testWindowSums_SingleWindow() {
        List<Integer> nums = List.of(1, 2, 3);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.windowSums(nums, 3);
        assertEquals(List.of(6), result);
    }

    @Test
    void testWindowSums_WindowSize1() {
        List<Integer> nums = List.of(1, 2, 3);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.windowSums(nums, 1);
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void testWindowSums_WindowSizeEqualsListSize() {
        List<Integer> nums = List.of(1, 2, 3);
        List<Integer> result = StreamInterviewProblemsSolutionsSade.windowSums(nums, 3);
        assertEquals(List.of(6), result);
    }

    @Test
    void testDuplicateEmails() {
        List<String> emails = List.of(
                "alice@example.com",
                "bob@test.com",
                "ALICE@example.com", // duplicate (case-insensitive)
                "charlie@test.com",
                "Bob@test.com" // duplicate
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.duplicateEmails(emails);
        assertEquals(2, result.size());
        assertTrue(result.contains("alice@example.com"));
        assertTrue(result.contains("bob@test.com"));
        // Should be sorted
        assertEquals("alice@example.com", result.get(0));
        assertEquals("bob@test.com", result.get(1));
    }

    @Test
    void testDuplicateEmails_NoDuplicates() {
        List<String> emails = List.of(
                "alice@example.com",
                "bob@test.com",
                "charlie@test.com"
        );
        List<String> result = StreamInterviewProblemsSolutionsSade.duplicateEmails(emails);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDuplicateEmails_EmptyList() {
        List<String> result = StreamInterviewProblemsSolutionsSade.duplicateEmails(List.of());
        assertTrue(result.isEmpty());
    }
}

