public class MyJVMTest_15316 {

    static Double ibc = new Double(1.);

    double simplec() {
        Double ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15316().simplec());
    }
}
