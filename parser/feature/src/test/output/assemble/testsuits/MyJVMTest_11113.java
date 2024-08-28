public class MyJVMTest_11113 {

    static Byte ibc = new Byte((byte) 1);

    byte remi_sumc2() {
        Byte j1 = ibc;
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = (byte) (j1 + ibc);
            j2 = (byte) (j2 + 2);
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11113().remi_sumc2());
    }
}
