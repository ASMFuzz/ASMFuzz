public class MyJVMTest_7749 {

    static int i = -326294573;

    int ival(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7749().ival(i));
    }
}
