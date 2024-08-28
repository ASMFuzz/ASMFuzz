public class MyJVMTest_2102 {

    static int x = 0;

    static int y = 0;

    static int z = 8;

    int statMethod(int x, int y, int z) {
        int j = 3;
        for (int i = 0; i < z; i++) {
            j += x * y;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2102().statMethod(x, y, z));
    }
}
