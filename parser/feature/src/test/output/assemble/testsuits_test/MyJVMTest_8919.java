public class MyJVMTest_8919 {

    static String str = "T=DZt/\\2%~";

    int IndexOfTest(String str) {
        return str.indexOf("1111111111111xx1x");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8919().IndexOfTest(str));
    }
}
