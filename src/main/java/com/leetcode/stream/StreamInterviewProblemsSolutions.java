package com.leetcode.stream;

import com.leetcode.stream.model.Employee;
import com.leetcode.stream.model.LineItem;
import com.leetcode.stream.model.Order;
import com.leetcode.stream.model.Person;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamInterviewProblemsSolutions {

    /* =========================
       EASY (1–10)
       ========================= */

    // 1) Names of adults (age >= 18)
    public static List<String> adultNames(List<Person> people) {
        if (people == null) return List.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.age() >= 18)
                .map(Person::name)
                .toList();
    }

    // 2) Trim, drop empty, uppercase
    public static List<String> normalize(List<String> input) {
        if (input == null) return List.of();
        return input.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(String::toUpperCase)
                .toList();
    }

    // 3) Count how many start with prefix
    public static long countPrefix(List<String> words, String prefix) {
        if (words == null || prefix == null) return 0L;
        return words.stream()
                .filter(Objects::nonNull)
                .filter(w -> w.startsWith(prefix))
                .count();
    }

    // 4) Sum of squares
    public static int sumSquares(List<Integer> nums) {
        if (nums == null) return 0;
        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(x -> x * x)
                .sum();
    }

    // 5) Find first even
    public static Optional<Integer> firstEven(List<Integer> nums) {
        if (nums == null) return Optional.empty();
        return nums.stream()
                .filter(Objects::nonNull)
                .filter(x -> x % 2 == 0)
                .findFirst();
    }

    // 6) Distinct cities (sorted)
    public static List<String> distinctCitiesSorted(List<Person> people) {
        if (people == null) return List.of();
        return people.stream()
                .filter(Objects::nonNull)
                .map(Person::city)
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .toList();
    }

    // 7) Join names with comma
    public static String joinNames(List<Person> people) {
        if (people == null) return "";
        return people.stream()
                .filter(Objects::nonNull)
                .map(Person::name)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
    }

    // 8) Partition into adults/minors
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        if (people == null) return Map.of(true, List.of(), false, List.of());
        return people.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(p -> p.age() >= 18));
    }

    // 9) Take top N after sorting desc
    public static List<Integer> topN(List<Integer> nums, int n) {
        if (nums == null || n <= 0) return List.of();
        return nums.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .toList();
    }

    // 10) Any invalid email? (must contain '@' and '.' after '@')
    public static boolean anyInvalidEmail(List<String> emails) {
        if (emails == null) return false;
        return emails.stream()
                .filter(Objects::nonNull)
                .anyMatch(e -> !isValidEmailBasic(e));
    }

    private static boolean isValidEmailBasic(String email) {
        String e = email.trim();
        int at = e.indexOf('@');
        if (at <= 0) return false;              // must have something before '@'
        int dot = e.indexOf('.', at + 1);
        return dot > at + 1 && dot < e.length() - 1; // '.' after '@' and not last char
    }


    /* =========================
       MEDIUM (11–22)
       ========================= */

    // 11) Group people by city
    public static Map<String, List<Person>> groupByCity(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(Person::city));
    }

    // 12) Count people per city
    public static Map<String, Long> countByCity(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(Person::city, Collectors.counting()));
    }

    // 13) Average age per city
    public static Map<String, Double> avgAgeByCity(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(Person::city, Collectors.averagingInt(Person::age)));
    }

    // 14) City -> list of names
    public static Map<String, List<String>> namesByCity(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.mapping(Person::name, Collectors.toList())
                ));
    }

    // 15) City -> unique names (set)
    public static Map<String, Set<String>> uniqueNamesByCity(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.mapping(Person::name, Collectors.toSet())
                ));
    }

    // 16) Flatten List<List<Integer>> -> distinct sorted numbers
    public static List<Integer> flattenDistinctSorted(List<List<Integer>> lists) {
        if (lists == null) return List.of();
        return lists.stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .toList();
    }

    // 17) Total order amount for PAID orders
    public static double totalPaid(List<Order> orders) {
        if (orders == null) return 0.0;
        return orders.stream()
                .filter(Objects::nonNull)
                .filter(o -> "PAID".equals(o.status()))
                .mapToDouble(Order::amount)
                .sum();
    }

    // 18) Top earner by department (Optional<Employee>)
    public static Map<String, Optional<Employee>> topEarnerByDept(List<Employee> emps) {
        if (emps == null) return Map.of();
        return emps.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.dept() != null)
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.maxBy(Comparator.comparingInt(Employee::salary))
                ));
    }

    // 19) Max salary by dept (return salary, default 0)
    public static Map<String, Integer> maxSalaryByDept(List<Employee> emps) {
        if (emps == null) return Map.of();
        return emps.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.dept() != null)
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::salary)),
                                opt -> opt.map(Employee::salary).orElse(0)
                        )
                ));
    }

    // 20) Second highest distinct number
    public static OptionalInt secondHighestDistinct(List<Integer> nums) {
        if (nums == null) return OptionalInt.empty();
        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();
    }

    // 21) Most frequent word (ties -> lexicographically smallest)
    public static Optional<String> mostFrequentWord(List<String> words) {
        if (words == null) return Optional.empty();

        Map<String, Long> freq = words.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freq.entrySet().stream()
                .max(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey, Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .or(() -> Optional.empty());
    }

    // 22) Product of non-zero numbers (ignore zeros, if empty return 1)
    public static int productNonZero(List<Integer> nums) {
        if (nums == null) return 1;
        return nums.stream()
                .filter(Objects::nonNull)
                .filter(x -> x != 0)
                .reduce(1, (a, b) -> a * b);
    }


    /* =========================
       MEDIUM+ (23–26)
       ========================= */

    // 23) Customer -> total spent from PAID orders
    public static Map<String, Double> totalSpentByCustomer(List<Order> orders) {
        if (orders == null) return Map.of();
        return orders.stream()
                .filter(Objects::nonNull)
                .filter(o -> "PAID".equals(o.status()))
                .filter(o -> o.customerId() != null)
                .collect(Collectors.groupingBy(
                        Order::customerId,
                        Collectors.summingDouble(Order::amount)
                ));
    }

    // 24) Order -> total price from line items (qty * unitPrice)
    public static Map<String, Double> orderTotalFromItems(List<LineItem> items) {
        if (items == null) return Map.of();
        return items.stream()
                .filter(Objects::nonNull)
                .filter(li -> li.orderId() != null)
                .collect(Collectors.groupingBy(
                        LineItem::orderId,
                        Collectors.summingDouble(li -> li.qty() * li.unitPrice())
                ));
    }

    // 25) Customer -> total items bought (qty) for PAID orders
    public static Map<String, Integer> totalQtyByCustomerPaid(List<Order> orders, List<LineItem> items) {
        if (orders == null || items == null) return Map.of();

        // orderId -> customerId for PAID orders
        Map<String, String> paidOrderToCustomer = orders.stream()
                .filter(Objects::nonNull)
                .filter(o -> "PAID".equals(o.status()))
                .filter(o -> o.id() != null && o.customerId() != null)
                .collect(Collectors.toMap(
                        Order::id,
                        Order::customerId,
                        (a, b) -> a // if duplicate order IDs, keep first
                ));

        return items.stream()
                .filter(Objects::nonNull)
                .filter(li -> li.orderId() != null)
                .filter(li -> paidOrderToCustomer.containsKey(li.orderId()))
                .collect(Collectors.groupingBy(
                        li -> paidOrderToCustomer.get(li.orderId()),
                        Collectors.summingInt(LineItem::qty)
                ));
    }

    // 26) Top 3 SKUs by revenue (sum(qty * unitPrice) per sku)
    public static List<String> top3SkusByRevenue(List<LineItem> items) {
        if (items == null) return List.of();

        Map<String, Double> revenueBySku = items.stream()
                .filter(Objects::nonNull)
                .filter(li -> li.sku() != null)
                .collect(Collectors.groupingBy(
                        LineItem::sku,
                        Collectors.summingDouble(li -> li.qty() * li.unitPrice())
                ));

        return revenueBySku.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }


    /* =========================
       HARD (27–30)
       ========================= */

    // 27) Stable de-dup by name (keep first seen)
    public static List<Person> distinctByNameKeepFirst(List<Person> people) {
        if (people == null) return List.of();

        LinkedHashMap<String, Person> map = people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.name() != null)
                .collect(Collectors.toMap(
                        Person::name,
                        Function.identity(),
                        (first, ignored) -> first,
                        LinkedHashMap::new
                ));

        return new ArrayList<>(map.values());
    }

    // 28) city -> people sorted by age asc then name
    public static Map<String, List<Person>> groupCitySorted(List<Person> people) {
        if (people == null) return Map.of();

        Comparator<Person> cmp = Comparator
                .comparingInt(Person::age)
                .thenComparing(Person::name, Comparator.nullsLast(String::compareTo));

        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.city() != null)
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted(cmp).toList()
                        )
                ));
    }

    // 29) Sliding window sum (size k)
    // Example: [1,2,3,4], k=3 -> [6,9]
    public static List<Integer> windowSums(List<Integer> nums, int k) {
        if (nums == null || k <= 0 || k > nums.size()) return List.of();

        // Treat nulls as 0 to keep it robust; change if you prefer to reject nulls.
        List<Integer> safe = nums.stream().map(x -> x == null ? 0 : x).toList();

        return IntStream.range(0, safe.size() - k + 1)
                .mapToObj(i -> safe.subList(i, i + k).stream().mapToInt(Integer::intValue).sum())
                .toList();
    }

    // 30) Detect duplicates case-insensitive; return duplicates list in lowercase distinct sorted
    public static List<String> duplicateEmails(List<String> emails) {
        if (emails == null) return List.of();

        Map<String, Long> freq = emails.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freq.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
