public class MyJVMTest_12168 {

    static Object o = 0;

    boolean test2(Object o) {
        return o instanceof A;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12168().test2(o));
    }
}
