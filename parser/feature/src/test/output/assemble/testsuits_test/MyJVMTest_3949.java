public class MyJVMTest_3949 {

    static short i = 32767;

    short test(short i) {
        Short ib = new Short(i);
        if ((i & 1) == 0)
            ib = (short) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3949().test(i));
    }
}
