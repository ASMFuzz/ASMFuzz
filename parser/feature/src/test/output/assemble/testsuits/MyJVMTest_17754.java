public class MyJVMTest_17754 {

    static int limit = 8;

    double test(int limit) {
        double v = 1;
        for (int i = 0; i < limit; i++) {
            v = v * 4;
            if (i + 1 < limit) {
                v = v * 2;
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17754().test(limit));
    }
}
