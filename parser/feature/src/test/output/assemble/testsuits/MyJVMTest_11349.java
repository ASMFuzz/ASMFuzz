public class MyJVMTest_11349 {

    static int x = 0;

    static int y = 0;

    static int z = 0;

    int statMethod(int x, int y, int z) {
        int j = 3;
        for (int i = 0; i < z; i++) {
            j += x * y;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11349().statMethod(x, y, z));
    }
}
