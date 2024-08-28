public class MyJVMTest_2893 {

    static short i = 2854;

    short testb(short i) {
        Short ib = i;
        if ((i & 1) == 0)
            ib = (short) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2893().testb(i));
    }
}
