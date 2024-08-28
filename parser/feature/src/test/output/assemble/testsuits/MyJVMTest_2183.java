public class MyJVMTest_2183 {

    byte remi_sumb() {
        Byte j = Byte.valueOf((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j = (byte) (j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2183().remi_sumb());
    }
}
