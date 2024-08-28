public class MyJVMTest_16459 {

    static short i = -32768;

    short simple2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = new Short((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16459().simple2(i));
    }
}
