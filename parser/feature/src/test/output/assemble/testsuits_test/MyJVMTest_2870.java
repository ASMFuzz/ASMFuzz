public class MyJVMTest_2870 {

    static Object o = 1;

    boolean test2(Object o) {
        return o instanceof A;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2870().test2(o));
    }
}
