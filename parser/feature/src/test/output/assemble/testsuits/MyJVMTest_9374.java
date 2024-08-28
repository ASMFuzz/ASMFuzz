import java.util.ArrayList;

public class MyJVMTest_9374 {

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    void reclaim() {
        keepAlive = null;
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9374().reclaim();
    }
}
