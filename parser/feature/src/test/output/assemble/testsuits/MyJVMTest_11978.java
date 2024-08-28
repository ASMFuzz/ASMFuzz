public class MyJVMTest_11978 {

    static Integer ib = 0;

    void dummy() {
    }

    int simplep_deop(Integer ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11978().simplep_deop(ib));
    }
}
