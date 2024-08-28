public class MyJVMTest_2394 {

    static int x = 0;

    String wahoo(int x) {
        return "wahoo " + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2394().wahoo(x));
    }
}
