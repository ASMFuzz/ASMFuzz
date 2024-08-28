public class MyJVMTest_17308 {

    static String tmpStr = "r^hu3xm~c%";

    static String value = "KyQ_:SS)^>";

    String setValue(String tmpStr) {
        this.value = tmpStr;
        if (!this.value.equals("YES"))
            throw new AssertionError();
        return tmpStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17308().setValue(tmpStr);
    }
}
