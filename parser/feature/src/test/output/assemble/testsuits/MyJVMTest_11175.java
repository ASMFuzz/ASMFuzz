public class MyJVMTest_11175 {

    static Object x = 1063026524;

    static Object y = -413611754;

    boolean eq(Object x, Object y) {
        return x == null ? y == null : x.equals(y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11175().eq(x, y));
    }
}
