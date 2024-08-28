public class MyJVMTest_3708 {

    static char c = Character.MAX_VALUE;

    char doh(char c) {
        System.out.println("doh(string)");
        return 'd';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3708().doh(c));
    }
}
