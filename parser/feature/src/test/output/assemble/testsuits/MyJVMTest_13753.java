public class MyJVMTest_13753 {

    static String str = "{j@faOZ%\"b";

    int IndexOfTest(String str) {
        return str.indexOf("1111111111111xx1x");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13753().IndexOfTest(str));
    }
}
