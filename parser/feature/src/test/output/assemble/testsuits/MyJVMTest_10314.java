public class MyJVMTest_10314 {

    static Long ibc = new Long(1);

    long simplec() {
        Long ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10314().simplec());
    }
}
