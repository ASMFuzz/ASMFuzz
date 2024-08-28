public class MyJVMTest_10512 {

    static short i = -27255;

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
        System.out.println(new MyJVMTest_10512().test2(i));
    }
}
