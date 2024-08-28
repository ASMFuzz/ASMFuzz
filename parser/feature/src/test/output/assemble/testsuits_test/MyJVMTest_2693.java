public class MyJVMTest_2693 {

    static Integer ib = 883618848;

    void dummy() {
    }

    int simplep_deop(Integer ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2693().simplep_deop(ib));
    }
}
