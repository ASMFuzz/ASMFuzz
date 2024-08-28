public class MyJVMTest_1939 {

    static Object x = 2;

    static Object y = 0;

    boolean eq(Object x, Object y) {
        return x == null ? y == null : x.equals(y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1939().eq(x, y));
    }
}
