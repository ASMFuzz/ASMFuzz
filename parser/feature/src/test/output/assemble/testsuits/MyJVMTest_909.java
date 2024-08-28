public class MyJVMTest_909 {

    static int i = -618177147;

    static boolean done = false;

    static Object elLoco = 3;

    boolean keepGoing(int i) {
        return (i % 128 != 0) || !done;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_909().keepGoing(i));
    }
}
