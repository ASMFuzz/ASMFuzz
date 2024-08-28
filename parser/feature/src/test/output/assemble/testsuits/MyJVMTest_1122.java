public class MyJVMTest_1122 {

    static Byte ibc = new Byte((byte) 1);

    byte remi_sumc_cond() {
        Byte j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (byte) (j + ibc);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1122().remi_sumc_cond());
    }
}
