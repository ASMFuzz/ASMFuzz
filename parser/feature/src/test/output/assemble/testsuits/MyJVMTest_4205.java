public class MyJVMTest_4205 {

    static Byte ibc = new Byte((byte) 1);

    byte simplec() {
        Byte ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4205().simplec());
    }
}
