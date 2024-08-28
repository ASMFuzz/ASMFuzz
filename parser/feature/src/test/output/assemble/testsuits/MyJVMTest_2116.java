public class MyJVMTest_2116 {

    static Double ib = 0.6961179390843151;

    void dummy() {
    }

    double simplep_deop(Double ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2116().simplep_deop(ib));
    }
}
