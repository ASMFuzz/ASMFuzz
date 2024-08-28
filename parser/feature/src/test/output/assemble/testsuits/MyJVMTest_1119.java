public class MyJVMTest_1119 {

    static Long ibc = new Long(1);

    long simplec() {
        Long ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1119().simplec());
    }
}
