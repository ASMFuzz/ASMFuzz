public class MyJVMTest_17120 {

    static String myString = "^]0FM/!2>@";

    static TestStringObjectInitialization test = null;

    void reset() {
        myString = "";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17120().reset();
    }
}
