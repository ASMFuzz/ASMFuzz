public class MyJVMTest_12467 {

    static int x = 0;

    static int y = 4;

    static int z = -1824831981;

    double statMethod(int x, int y, int z) {
        double j = 5.0D;
        for (int i = 10; i > z; i--) j += x * y;
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12467().statMethod(x, y, z));
    }
}
