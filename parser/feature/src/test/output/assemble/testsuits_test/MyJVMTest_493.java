public class MyJVMTest_493 {

    static int b = 0;

    static int value = 4;

    boolean equals(int b) {
        return value == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_493().equals(b));
    }
}
