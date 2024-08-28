import java.awt.geom.Area;

public class MyJVMTest_6743 {

    void run() {
        new Area().createTransformedArea(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6743().run();
    }
}
