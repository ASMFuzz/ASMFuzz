public class MyJVMTest_2715 {

    static int i = 0;

    static int modulus = 8;

    static int multiplier = 0;

    static int ADDEND = 22;

    int map(int i) {
        return (multiplier * i + ADDEND) % modulus;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2715().map(i));
    }
}
