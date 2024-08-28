public class MyJVMTest_7683 {

    static Byte j = -128;

    byte remi_sump_cond(Byte j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (byte) (j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7683().remi_sump_cond(j));
    }
}
