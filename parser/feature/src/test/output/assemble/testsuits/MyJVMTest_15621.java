public class MyJVMTest_15621 {

    void m2() {
        Class<?> good_1 = C.class;
        Class<?> good_2 = C[].class;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15621().m2();
    }
}
