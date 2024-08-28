public class MyJVMTest_7297 {

    static int initialValue = -1145464239;

    static int RAND_MULT = 1103515245;

    static int RAND_ADD = 12345;

    int runLinCon(int initialValue) {
        int temp = (initialValue * RAND_MULT) + RAND_ADD;
        return temp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7297().runLinCon(initialValue));
    }
}
