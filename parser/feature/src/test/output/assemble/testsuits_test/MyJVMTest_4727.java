public class MyJVMTest_4727 {

    static String[] strings = new String[1024];

    static int ITERATIONS = 100000;

    int test_subvar() {
        int s = 0;
        int v = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            v += strings[s].indexOf(strings[s + 1]);
            s += 2;
            if (s >= strings.length)
                s = 0;
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4727().test_subvar());
    }
}
