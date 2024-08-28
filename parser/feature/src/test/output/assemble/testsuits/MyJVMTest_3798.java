public class MyJVMTest_3798 {

    static Byte ibc = new Byte((byte) 1);

    byte remi_sumc2_cond() {
        Byte j1 = ibc;
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = (byte) (j1 + ibc);
            } else {
                j2 = (byte) (j2 + 2);
            }
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3798().remi_sumc2_cond());
    }
}
