public class MyJVMTest_9926 {

    static short i = 0;

    static Short ib1 = -22635;

    short testp2(short i, Short ib1) {
        Short ib2 = (short) (i + 1);
        if ((i & 1) == 0) {
            ib1 = new Short((short) (i + 1));
            ib2 = (short) (i + 2);
        }
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9926().testp2(i, ib1));
    }
}
