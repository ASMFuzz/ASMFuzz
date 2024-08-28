import java.util.stream.*;
import java.util.*;

public class MyJVMTest_17636 {

    void test(Stream<List<?>> sl) {
        Runnable r = new Runnable() {

            public void run() {
                Stream<List<?>> constructor = sl.filter(c -> true);
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17636().run();
    }
}
