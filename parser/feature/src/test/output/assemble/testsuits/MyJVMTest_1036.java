public class MyJVMTest_1036 {

    static int i = 1770465643;

    String getHtmlText(int i) {
        return "<html><b><i>" + i + "</b></i>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1036().getHtmlText(i));
    }
}
