public class MyJVMTest_9977 {

    static short i = -32768;

    static Short ib = -32768;

    short testp(short i, Short ib) {
        if ((i & 1) == 0)
            ib = new Short((short) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9977().testp(i, ib));
    }
}
