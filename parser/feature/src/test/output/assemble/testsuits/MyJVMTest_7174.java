public class MyJVMTest_7174 {

    static int value = 0;

    int checkMethod(int value) {
        return Math.negateExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7174().checkMethod(value));
    }
}
