public class MyJVMTest_6122 {

    static int pos = 0;

    static String input = "EVmUQ\\ ?KK";

    boolean hasInput() {
        return pos < input.length();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6122().hasInput());
    }
}
