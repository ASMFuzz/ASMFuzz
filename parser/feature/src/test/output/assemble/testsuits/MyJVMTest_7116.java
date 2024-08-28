public class MyJVMTest_7116 {

    static Byte ibc = new Byte((byte) 1);

    byte remi_sumc() {
        Byte j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = (byte) (j + ibc);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7116().remi_sumc());
    }
}
