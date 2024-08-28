import java.awt.geom.Area;

public class MyJVMTest_4114 {

    void run() {
        new Area().exclusiveOr(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4114().run();
    }
}
