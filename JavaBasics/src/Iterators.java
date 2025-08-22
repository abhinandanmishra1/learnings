import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    void forLoop() {
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // traditional for loop
        for(int i = 0; i < fruits.length; i++) {
            System.out.println("Traditional: " + fruits[i]);
        }

        // enhanced for loop
        for(String fruit: fruits) {
            System.out.println("Enhanced" + fruit);
        }
    }

    void iterators() {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Elephant");
        animals.add("Camel");

        Iterator<String> it = animals.iterator();
        // the starting value is not needed here
        // (-1) -> Cat -> Dog -> Elephant  -> Camel -> (-1)  Doubly LinkedList

        // this loop works according to above logic
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        var example = new Iterators();

        example.forLoop();
        example.iterators();
    }
}
