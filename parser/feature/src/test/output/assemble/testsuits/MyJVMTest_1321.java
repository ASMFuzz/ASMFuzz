public class MyJVMTest_1321 {

    boolean done() {
        return (--iter > 0);
    }

    static int INITSIZE = 10000;

    static int[] d = { 1, 2, 3, 4 };

    static int i = 1410052604, size = 2;

    static int iter = 5;

    int test() {
        while (done()) {
            size = INITSIZE;
            for (i = 0; i < size; i++) {
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
                d[0] = d[1];
                d[1] = d[2];
                d[2] = d[3];
                d[3] = d[0];
            }
            if (d[0] == d[1]) {
                System.out.println("test failed: iter=" + iter + "  i=" + i + " d[] = { " + d[0] + ", " + d[1] + ", " + d[2] + ", " + d[3] + " } ");
                System.exit(97);
            }
        }
        return d[3];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1321().test());
    }
}
