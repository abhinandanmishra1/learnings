import java.util.*;

public class CollectionFramework {
    void run() {
        // ----------------------------
        // 1. List (ArrayList & LinkedList)
        // ----------------------------
        List<String> list = new ArrayList<>();
        list.add("Abhinandan");
        list.add("Mishra");
        list.add("Mishra"); // duplicate allowed

        System.out.println("ArrayList: " + list);

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) linkedList.add(i);
        System.out.println("LinkedList: " + linkedList);

        // ----------------------------
        // 2. Set (HashSet, LinkedHashSet, TreeSet)
        // ----------------------------
        String[] names = {"Abhi", "Mishra", "abhi", "abhi"};

        Set<String> hashSet = new HashSet<>(List.of(names));
        System.out.println("HashSet (no order, no duplicates): " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>(List.of(names));
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        Set<String> treeSet = new TreeSet<>(List.of(names));
        System.out.println("TreeSet (sorted order): " + treeSet);

        // ----------------------------
        // 3. Queue (PriorityQueue, ArrayDeque)
        // ----------------------------
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println("PriorityQueue (min-heap): " + pq);
        System.out.println("Polling from PQ: " + pq.poll() + ", " + pq.poll());

        Deque<String> dq = new ArrayDeque<>();
        dq.addFirst("First");
        dq.addLast("Last");
        System.out.println("ArrayDeque: " + dq);

        // ----------------------------
        // 4. Map (HashMap, LinkedHashMap, TreeMap)
        // ----------------------------
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Alice", 28); // overwrite
        System.out.println("HashMap: " + hashMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("C", 3);
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // ----------------------------
        // 5. Using custom class in collections
        // ----------------------------
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Sheru", 12));
        dogs.add(new Dog("Tommy", 5));
        System.out.println("Dogs List: " + dogs);
    }
}
