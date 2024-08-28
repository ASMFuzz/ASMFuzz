import java.lang.instrument.ClassFileTransformer;

public class MyJVMTest_10173 {

    static Object[] array = {0,3,1,0,3,0,8,-1551928033,0,-721888500};

    static int DUMMY_SIZE = 4096 - 16 - 8;

    static int HUMON_SIZE = 4 * 1024 * 1024 - 16 - 8;

    static int SKIP = 13;

    static byte[] humon = null;

    static boolean first = true;

    void makeHumongousRegions() {
        if (!first) {
            return;
        }
        System.out.println("===============================================================================");
        first = false;
        int total = 0;
        array = new Object[100000];
        System.out.println(array);
        for (int n = 0, i = 0; total < 8 * 1024 * 1024; n++) {
            Object x = new byte[DUMMY_SIZE];
            if ((n % SKIP) == 0) {
                array[i++] = x;
                total += DUMMY_SIZE;
            }
        }
        System.gc();
        humon = new byte[HUMON_SIZE];
        array = null;
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10173().makeHumongousRegions();
    }
}
