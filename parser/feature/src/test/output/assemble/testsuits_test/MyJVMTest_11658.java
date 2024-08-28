public class MyJVMTest_11658 {

    static int x = 0;

    String wahoo(int x) {
        return "wahoo " + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11658().wahoo(x));
    }
}
