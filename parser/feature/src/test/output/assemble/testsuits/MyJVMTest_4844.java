public class MyJVMTest_4844 {

    static short i = -5175;

    short testb2(short i) {
        Short ib1 = i;
        Short ib2 = (short) (i + 1);
        if ((i & 1) == 0) {
            ib1 = (short) (i + 1);
            ib2 = (short) (i + 2);
        }
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4844().testb2(i));
    }
}
