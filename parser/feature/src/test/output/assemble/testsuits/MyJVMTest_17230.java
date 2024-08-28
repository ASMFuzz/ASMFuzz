public class MyJVMTest_17230 {

    byte remi_sum2() {
        Byte j1 = new Byte((byte) 1);
        Byte j2 = new Byte((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Byte((byte) (j1 + 1));
            j2 = new Byte((byte) (j2 + 2));
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17230().remi_sum2());
    }
}
