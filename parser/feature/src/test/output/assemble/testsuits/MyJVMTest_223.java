import java.util.ArrayList;

public class MyJVMTest_223 {

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    void reclaim() {
        keepAlive = null;
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_223().reclaim();
    }
}
