public class MyJVMTest_11656 {

    byte remi_sumb2() {
        Byte j1 = Byte.valueOf((byte) 1);
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = (byte) (j1 + 1);
            j2 = (byte) (j2 + 2);
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11656().remi_sumb2());
    }
}
