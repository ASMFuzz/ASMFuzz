public class MyJVMTest_3944 {

    static String message = "fOh4aDcFWw";

    static int state = 2;

    static int size = 0;

    void doThis() {
        for (int i = 0; i < size; i++) {
            System.out.println(" .... Message " + message);
            state++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3944().doThis();
    }
}
