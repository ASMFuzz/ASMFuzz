public class MyJVMTest_8969 {

    static int b = 0;

    static int value = 0;

    boolean equals(int b) {
        return value == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8969().equals(b));
    }
}
