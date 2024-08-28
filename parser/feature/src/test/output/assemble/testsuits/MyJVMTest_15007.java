public class MyJVMTest_15007 {

    static int i = 0;

    Integer foob(int i) {
        return Integer.valueOf(i);
    }

    void dummy() {
    }

    int simplef_deop(int i) {
        Integer ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15007().simplef_deop(i));
    }
}
