public class MyJVMTest_13568 {

    static Byte ibc = new Byte((byte) 1);

    byte simplec() {
        Byte ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13568().simplec());
    }
}
