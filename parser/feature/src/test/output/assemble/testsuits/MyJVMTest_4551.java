import java.util.LinkedList;
import java.util.List;

public class MyJVMTest_4551 {

    void generateOOME() throws Exception {
        List<Object> leak = new LinkedList<>();
        try {
            while (true) {
                leak.add(new byte[1024 * 1024]);
            }
        } catch (OutOfMemoryError e) {
        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4551().generateOOME();
    }
}
