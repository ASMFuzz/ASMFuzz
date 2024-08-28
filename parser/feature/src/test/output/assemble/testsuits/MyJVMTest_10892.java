public class MyJVMTest_10892 {

    byte remi_summ2() {
        Byte j1 = new Byte((byte) 1);
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Byte((byte) (j1 + 1));
            j2 = (byte) (j2 + 2);
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10892().remi_summ2());
    }
}
