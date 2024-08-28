import java.awt.geom.Area;

public class MyJVMTest_17221 {

    static Runnable r = () -> {
    };

    void run() {
        new Area(null);
    }

    static boolean verbose = false;

    static int numfailures = 0;

    Runnable test(Runnable r) {
        try {
            r.run();
            numfailures++;
            if (verbose) {
                new RuntimeException(r + " failed to throw NPE").printStackTrace();
            }
        } catch (NullPointerException e) {
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17221().test(r);
    }
}
