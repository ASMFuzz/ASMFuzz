public class MyJVMTest_2835 {

    static int x = 7;

    static String s = "B9_Y]m+?iB";

    int getIndex() {
        return x++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2835().getIndex());
    }
}
