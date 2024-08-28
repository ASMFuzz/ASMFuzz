public class MyJVMTest_1454 {

    static Object[] a2 = { 7, 4, 1, 1092038810, 6, -321435043, 0, 0, 0, -470839 };

    Object m2(Object[] a2) {
        A[] a1 = new A[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        return a1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1454().m2(a2));
    }
}
