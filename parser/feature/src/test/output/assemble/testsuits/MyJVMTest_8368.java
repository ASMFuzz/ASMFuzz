import java.util.ArrayList;

public class MyJVMTest_8368 {

    static ArrayList<byte[]> keepAlive = new ArrayList<byte[]>();

    void fragment() {
        for (int i = 0; i < keepAlive.size(); i += 2) {
            keepAlive.set(i, null);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8368().fragment();
    }
}
