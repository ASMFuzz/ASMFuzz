public class MyJVMTest_10539 {

    static Object o1 = -325648609;

    static Object o2 = 1;

    boolean eq(Object o1, Object o2) {
        return o1.equals(o2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10539().eq(o1, o2));
    }
}
