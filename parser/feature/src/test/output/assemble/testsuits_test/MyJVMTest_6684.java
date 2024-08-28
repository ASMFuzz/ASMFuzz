public class MyJVMTest_6684 {

    byte remi_sum_cond() {
        Byte j = new Byte((byte) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Byte((byte) (j + 1));
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6684().remi_sum_cond());
    }
}
