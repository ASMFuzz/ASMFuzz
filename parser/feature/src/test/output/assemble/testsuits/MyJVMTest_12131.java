public class MyJVMTest_12131 {

    static int x = 2;

    static String s = ",o46mHL%ff";

    int getIndex() {
        return x++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12131().getIndex());
    }
}
