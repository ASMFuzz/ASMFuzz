public class MyJVMTest_10227 {

    static int i = 4;

    String getHtmlText(int i) {
        return "<html><b><i>" + i + "</b></i>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10227().getHtmlText(i));
    }
}
