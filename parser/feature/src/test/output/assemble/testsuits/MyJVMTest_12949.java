import java.io.File;

public class MyJVMTest_12949 {

    static String dirParam1Param1 = "08QYm3+lP{";

    static File dirParam1 = new File(dirParam1Param1);

    static String dirParam2 = "Z//QQW'e?R";

    static File dir = new File(dirParam1, dirParam2);

    boolean cleanup(File dir) throws Throwable {
        boolean rc = true;
        File[] x = dir.listFiles();
        if (x != null) {
            for (int i = 0; i < x.length; i++) {
                rc &= x[i].delete();
            }
        }
        return rc & dir.delete();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12949().cleanup(dir));
    }
}
