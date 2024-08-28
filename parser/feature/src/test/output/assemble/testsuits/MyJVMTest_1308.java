public class MyJVMTest_1308 {

    static short i = 32767;

    short test2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = new Short((short) (i + 1));
        if ((i & 1) == 0) {
            ib1 = new Short((short) (i + 1));
            ib2 = new Short((short) (i + 2));
        }
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1308().test2(i));
    }
}
