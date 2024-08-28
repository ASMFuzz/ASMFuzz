public class MyJVMTest_16823 {

    static int initialValue = 0;

    static int RAND_MULT = 1103515245;

    static int RAND_ADD = 12345;

    int runLinCon(int initialValue) {
        int temp = (initialValue * RAND_MULT) + RAND_ADD;
        return temp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16823().runLinCon(initialValue));
    }
}
