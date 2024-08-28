public class MyJVMTest_16697 {

    static int value = 5213410;

    int checkMethod(int value) {
        return Math.negateExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16697().checkMethod(value));
    }
}
