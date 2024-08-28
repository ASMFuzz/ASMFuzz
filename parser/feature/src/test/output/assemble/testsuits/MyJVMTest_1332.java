public class MyJVMTest_1332 {

    static Object o1 = 2;

    static Object o2 = -314661062;

    boolean eq(Object o1, Object o2) {
        return o1.equals(o2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1332().eq(o1, o2));
    }
}
