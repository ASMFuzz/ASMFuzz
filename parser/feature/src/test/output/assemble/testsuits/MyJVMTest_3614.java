import java.io.File;

public class MyJVMTest_3614 {

    static String dirParam1 = "$n:,FPv8i,";

    static File dir = new File(dirParam1);

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
        System.out.println(new MyJVMTest_3614().cleanup(dir));
    }
}
