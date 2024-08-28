import java.util.*;

public class MyJVMTest_12114 {

    void t(boolean b) {
        (b ? Collections.emptyList() : new Iterable<String>() {

            public Iterator<String> iterator() {
                return null;
            }
        }).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12114().iterator());
    }
}
