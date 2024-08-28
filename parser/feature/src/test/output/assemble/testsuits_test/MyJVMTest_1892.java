public class MyJVMTest_1892 {

    static Object x = 0;

    static Object y = -1015293157;

    Object check(Object x, Object y) throws Exception {
        if (x != y) {
            throw new Exception("named");
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1892().check(x, y);
    }
}
