public class MyJVMTest_11123 {

    static Object x = 0;

    static Object y = -406714314;

    Object check(Object x, Object y) throws Exception {
        if (x != y) {
            throw new Exception("named");
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11123().check(x, y);
    }
}
