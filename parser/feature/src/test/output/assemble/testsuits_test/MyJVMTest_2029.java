import java.awt.geom.Area;

public class MyJVMTest_2029 {

    void run() {
        new Area().subtract(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2029().run();
    }
}
