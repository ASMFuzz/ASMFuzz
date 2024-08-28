public class MyJVMTest_2484 {

    static short i = -32768;

    short simplem2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2484().simplem2(i));
    }
}
