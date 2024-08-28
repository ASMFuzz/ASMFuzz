public class MyJVMTest_12002 {

    static int i = 0;

    static int modulus = 7;

    static int multiplier = -1311604549;

    static int ADDEND = 22;

    int map(int i) {
        return (multiplier * i + ADDEND) % modulus;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12002().map(i));
    }
}
