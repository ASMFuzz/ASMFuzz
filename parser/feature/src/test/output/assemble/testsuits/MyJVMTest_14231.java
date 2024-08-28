public class MyJVMTest_14231 {

    static String error = "AxL@'?Hs[m";

    static int pos = -1414632921;

    String handleError(String error, int pos) {
        throw new Error(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14231().handleError(error, pos);
    }
}
