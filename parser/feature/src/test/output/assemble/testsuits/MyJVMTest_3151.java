public class MyJVMTest_3151 {

    static int x = 0;

    static int y = 6;

    static int z = 3;

    double statMethod(int x, int y, int z) {
        double j = 5.0D;
        for (int i = 10; i > z; i--) j += x * y;
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3151().statMethod(x, y, z));
    }
}
