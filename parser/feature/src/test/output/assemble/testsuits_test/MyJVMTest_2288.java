public class MyJVMTest_2288 {

    String helpInlinedSyncDecompile() {
        return "decompile at exception catch with an inlined synchronized method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2288().helpInlinedSyncDecompile());
    }
}
