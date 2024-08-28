public class MyJVMTest_4506 {

    int f1() {
        return 0;
    }

    int f2() {
        return 0;
    }

    int f3() {
        return 0;
    }

    static int a = 4, b = 2, c = 7, d = 6;

    void m() {
        boolean cond1 = (a < b & c > d);
        boolean cond2 = (f1() < f2() & c > d);
        boolean cond3 = (f1() < b & f3() > d);
        boolean cond4 = (f1() < b & f3() > 1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4506().m();
    }
}
