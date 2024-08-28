public class MyJVMTest_7582 {

    byte remi_sumb_cond() {
        Byte j = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (byte) (j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7582().remi_sumb_cond());
    }
}
