public class MyJVMTest_10090 {

    static int i = -241213629;

    static boolean done = false;

    static Object elLoco = 5;

    boolean keepGoing(int i) {
        return (i % 128 != 0) || !done;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10090().keepGoing(i));
    }
}
