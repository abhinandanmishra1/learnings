class Box<T>{
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

public class Generics {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();
        stringBox.setValue("Hey I am box of string type");
        integerBox.setValue(190);
        System.out.println(stringBox.getValue());
        System.out.println(integerBox.getValue() + " is value of integer box");
    }
}
