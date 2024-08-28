public class MyJVMTest_9430 {

    static byte i = -128;

    byte testb(byte i) {
        Byte ib = i;
        if ((i & 1) == 0)
            ib = (byte) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9430().testb(i));
    }
}
