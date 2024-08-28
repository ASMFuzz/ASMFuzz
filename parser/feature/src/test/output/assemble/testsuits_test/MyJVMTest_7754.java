public class MyJVMTest_7754 {

    static String tmpStr = "f>gTz\\iRyR";

    static String value = "{-&_XX~Qg!";

    String setValue(String tmpStr) {
        this.value = tmpStr;
        if (!this.value.equals("YES"))
            throw new AssertionError();
        return tmpStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7754().setValue(tmpStr);
    }
}
