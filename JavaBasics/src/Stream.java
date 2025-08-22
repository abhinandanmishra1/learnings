import java.util.*;
import java.util.stream.Collectors;

class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Custom mapper method (joins first + last name with ----)
    public String concatenateFirstAndLastName() {
        return Arrays.stream(name.split(" ")).collect(Collectors.joining("----"));
    }
}

public class Stream {

    public static int getLength(String str) {
        return str.length();
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Abhinandan", "Ekansh", "Vinay", "Abhinandan");
        System.out.println("Original List: " + names);

        // ✅ MAP: transform each element
        var upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase Names: " + upperCaseNames);

        var nameLengths = names.stream().map(Stream::getLength).collect(Collectors.toList());
        System.out.println("Name Lengths: " + nameLengths);

        // ✅ FILTER: keep only matching values
        var filteredNames = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println("Filtered (Starts with A): " + filteredNames);

        // ✅ SORTED
        var sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames);

        // ✅ DISTINCT (removes duplicates)
        var distinctNames = names.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct Names: " + distinctNames);

        // ✅ LIMIT + SKIP
        var limited = names.stream().limit(2).collect(Collectors.toList());
        System.out.println("Limit(2): " + limited);

        var skipped = names.stream().skip(2).collect(Collectors.toList());
        System.out.println("Skip(2): " + skipped);

        // ✅ REDUCE (combine elements into single value)
        var concatenatedName = names.stream().reduce("", (a, b) -> a + "|" + b);
        System.out.println("Reduced (concatenated): " + concatenatedName);

        var totalLength = names.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println("Reduced (total length): " + totalLength);

        // ✅ COLLECTORS (joining, grouping, partitioning)
        var joinedNames = names.stream().collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);

        var groupedByLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        var partitionedByA = names.stream().collect(Collectors.partitioningBy(name -> name.startsWith("A")));
        System.out.println("Partitioned by StartsWith(A): " + partitionedByA);

        // ✅ FLATMAP (flatten nested lists)
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        var flatList = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("FlatMap Example: " + flatList);

        // ✅ FOR EACH (terminal operation)
        System.out.print("ForEach Printing: ");
        names.stream().forEach(n -> System.out.print(n + " | "));
        System.out.println();

        // ✅ CUSTOM CLASS WITH STREAM
        User[] users = new User[]{
                new User("Abhinandan Mishra"),
                new User("Harsh Mishra")
        };

        var concatenatedUsers = Arrays.stream(users)
                .map(User::concatenateFirstAndLastName)
                .collect(Collectors.toList());
        System.out.println("User concatenated names: " + concatenatedUsers);
    }
}
