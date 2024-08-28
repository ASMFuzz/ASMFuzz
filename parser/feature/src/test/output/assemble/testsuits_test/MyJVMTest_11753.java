public class MyJVMTest_11753 {

    static short i = 32767;

    short simplem2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11753().simplem2(i));
    }
}
