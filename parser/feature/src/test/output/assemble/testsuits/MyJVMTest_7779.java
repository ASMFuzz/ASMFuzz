public class MyJVMTest_7779 {

    static Byte j = -128;

    byte remi_sump(Byte j) {
        for (int i = 0; i < 1000; i++) {
            j = new Byte((byte) (j + 1));
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7779().remi_sump(j));
    }
}
