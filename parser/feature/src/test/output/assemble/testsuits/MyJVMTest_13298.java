public class MyJVMTest_13298 {

    static short i = 0;

    short test(short i) {
        Short ib = new Short(i);
        if ((i & 1) == 0)
            ib = (short) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13298().test(i));
    }
}
