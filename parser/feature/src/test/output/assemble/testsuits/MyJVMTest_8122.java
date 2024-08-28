public class MyJVMTest_8122 {

    static Byte j1 = -128;

    byte remi_sump2_cond(Byte j1) {
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Byte((byte) (j1 + 1));
            } else {
                j2 = (byte) (j2 + 2);
            }
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8122().remi_sump2_cond(j1));
    }
}
