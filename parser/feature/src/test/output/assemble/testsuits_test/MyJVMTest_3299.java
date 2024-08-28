public class MyJVMTest_3299 {

    static Test7199742 t = null;

    static int m = 0;

    static int ITERS = 10000000;

    Test7199742 test(Test7199742 t, int m) {
        int i = -(ITERS / 2);
        if (i == 0)
            return null;
        Test7199742 v = null;
        while (i < ITERS) {
            if ((i & m) == 0) {
                v = t;
            }
            i++;
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3299().test(t, m));
    }
}
