import java.util.ArrayList;

public class MyJVMTest_17664 {

    static int objectSize = 2;

    static int allocSize = 200 * 1024 * 1024;

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    int allocate(int objectSize) {
        keepAlive = new ArrayList<>();
        for (int i = 0; i < allocSize; i += objectSize) {
            keepAlive.add(new byte[objectSize]);
        }
        return objectSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17664().allocate(objectSize);
    }
}
