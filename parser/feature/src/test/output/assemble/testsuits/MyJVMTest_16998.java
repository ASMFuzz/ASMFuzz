import java.util.concurrent.atomic.AtomicInteger;

public class MyJVMTest_16998 {

    static AtomicInteger nextId = new AtomicInteger(0);

    Integer initialValue() {
        return nextId.getAndIncrement();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16998().initialValue());
    }
}
