public class MyJVMTest_4289 {

    static Exception exception = new Exception();

    static String[] array = {"x!)|AO6e?)","p\"vrF6'v0C","FjtF&jM--G","8wujt>S&t4","XsS*+T=^~U","}~|x4lW$tj","88W4`ri$Bc","oX4^_+k3s$","\\v!u,ap.?_","Oe3mwmpEIt"};

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected error", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4289().exceptionThrown(exception);
    }
}
