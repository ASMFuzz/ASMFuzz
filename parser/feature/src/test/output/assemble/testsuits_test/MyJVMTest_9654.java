public class MyJVMTest_9654 {

    static int b = 3;

    static int value = 7;

    boolean equals(int b) {
        return value == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9654().equals(b));
    }
}
