import java.util.ArrayList;

public class MyJVMTest_9251 {

    static int objectSize = 4;

    void allocate(int objectSize) {
        keepAlive = new ArrayList<>();
        for (int i = 0; i < allocSize; i += objectSize) {
            keepAlive.add(new byte[objectSize]);
        }
    }

    void fragment() {
        for (int i = 0; i < keepAlive.size(); i += 2) {
            keepAlive.set(i, null);
        }
    }

    static int allocSize = 100 * 1024 * 1024;

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    int test(int objectSize) throws Exception {
        System.out.println("Allocating");
        allocate(objectSize);
        System.out.println("Fragmenting");
        fragment();
        System.out.println("Reclaiming");
        System.gc();
        return objectSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9251().test(objectSize);
    }
}
