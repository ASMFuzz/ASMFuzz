import java.util.function.Consumer;

public class MyJVMTest_3212 {

    static Consumer<T> consumer = null;

    static T value = null;

    <T> Consumer<T> forAll(Consumer<T> consumer, T value) {
        consumer.accept(value);
        return consumer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3212().forAll(consumer, value);
    }
}
