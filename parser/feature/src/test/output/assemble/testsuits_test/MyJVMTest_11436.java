public class MyJVMTest_11436 {

    byte remi_sumb() {
        Byte j = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j = (byte) (j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11436().remi_sumb());
    }
}
