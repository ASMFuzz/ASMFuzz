public class MyJVMTest_15587 {

    static int pos = 0;

    static String input = "oSqD3E<?Q ";

    boolean hasInput() {
        return pos < input.length();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15587().hasInput());
    }
}
