public class MyJVMTest_14132 {

    static String erroutput = "oops, complex problem with diagnostics";

    String getUIClassID() {
        return "BrokenUI";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14132().getUIClassID());
    }
}
