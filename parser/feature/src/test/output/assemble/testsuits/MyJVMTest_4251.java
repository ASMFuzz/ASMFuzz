public class MyJVMTest_4251 {

    static String str = "11111xx11111xx1x";

    int IndexOfTest(String str) {
        return str.indexOf("11111xx1x");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4251().IndexOfTest(str));
    }
}
