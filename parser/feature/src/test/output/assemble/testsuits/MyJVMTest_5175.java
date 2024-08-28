public class MyJVMTest_5175 {

    static String str = "y<qzOMy/q<";

    int IndexOfTest(String str) {
        return str.indexOf("11111xx1x");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5175().IndexOfTest(str));
    }
}
