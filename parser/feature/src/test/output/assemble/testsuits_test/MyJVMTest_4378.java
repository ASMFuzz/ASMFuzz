public class MyJVMTest_4378 {

    static String str = "TP\":^o0;*K";

    int IndexOfTest(String str) {
        return str.indexOf("1111111111111xx1x");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4378().IndexOfTest(str));
    }
}
