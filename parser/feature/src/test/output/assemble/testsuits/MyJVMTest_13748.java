public class MyJVMTest_13748 {

    static Short ib = 6623;

    void dummy() {
    }

    short simplep_deop(Short ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13748().simplep_deop(ib));
    }
}
