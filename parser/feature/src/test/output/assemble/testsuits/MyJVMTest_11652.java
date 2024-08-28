public class MyJVMTest_11652 {

    static String msg = "WI@l2Pb3X7";

    int Runner() {
        counter = counter * -1;
        int i = counter;
        if (counter < 2)
            counter += Runner();
        return i;
    }

    static int counter = 1;

    int run(String msg) {
        try {
            Runner();
        } catch (StackOverflowError e) {
            System.out.println(msg + " caught stack overflow error.");
            return 0;
        } catch (OutOfMemoryError e) {
            return 0;
        }
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11652().run(msg));
    }
}
