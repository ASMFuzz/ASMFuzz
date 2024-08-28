import java.awt.geom.Area;

public class MyJVMTest_15302 {

    void run() {
        new Area().transform(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15302().run();
    }
}
