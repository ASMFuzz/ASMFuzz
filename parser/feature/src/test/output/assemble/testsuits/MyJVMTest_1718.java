public class MyJVMTest_1718 {

    static Byte j1 = 116;

    byte remi_sump2(Byte j1) {
        Byte j2 = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Byte((byte) (j1 + 1));
            j2 = (byte) (j2 + 2);
        }
        return (byte) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1718().remi_sump2(j1));
    }
}
