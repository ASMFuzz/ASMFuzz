import java.security.*;

public class MyJVMTest_561 {

    static int refresher = 0;

    void refresh() {
        refresher++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_561().refresh();
    }
}
