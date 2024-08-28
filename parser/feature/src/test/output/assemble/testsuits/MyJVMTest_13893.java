public class MyJVMTest_13893 {

    int f1() {
        return 0;
    }

    int f2() {
        return 0;
    }

    int f3() {
        return 0;
    }

    static int a = 7, b = 0, c = 1156334474, d = 1990569546;

    void m() {
        boolean cond1 = (a < b & c > d);
        boolean cond2 = (f1() < f2() & c > d);
        boolean cond3 = (f1() < b & f3() > d);
        boolean cond4 = (f1() < b & f3() > 1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13893().m();
    }
}
