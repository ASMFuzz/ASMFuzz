public class MyJVMTest_5176 {

    static int i = 420781231;

    char toHex(int i) {
        if (i <= 9) {
            return (char) ('0' + i);
        } else {
            return (char) ('A' + i - 10);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5176().toHex(i));
    }
}
