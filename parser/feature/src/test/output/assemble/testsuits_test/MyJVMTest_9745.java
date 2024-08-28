import java.util.ArrayList;

public class MyJVMTest_9745 {

    static int objectSize = 1824192727;

    static int allocSize = 100 * 1024 * 1024;

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    int allocate(int objectSize) {
        keepAlive = new ArrayList<>();
        for (int i = 0; i < allocSize; i += objectSize) {
            keepAlive.add(new byte[objectSize]);
        }
        return objectSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9745().allocate(objectSize);
    }
}
