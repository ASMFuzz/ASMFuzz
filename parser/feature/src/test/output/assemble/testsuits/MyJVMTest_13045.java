public class MyJVMTest_13045 {

    static char c = Character.MIN_VALUE;

    char doh(char c) {
        System.out.println("doh(string)");
        return 'd';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13045().doh(c));
    }
}
