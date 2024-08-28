public class MyJVMTest_10670 {

    static Object[] a2 = { 0, 4, 5, 0, -1859255993, 895943260, 7, 0, 0, -1732228163 };

    Object m2(Object[] a2) {
        A[] a1 = new A[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        return a1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10670().m2(a2));
    }
}
