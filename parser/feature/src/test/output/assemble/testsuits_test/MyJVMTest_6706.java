public class MyJVMTest_6706 {

    static int i = 6;

    Integer foob(int i) {
        return Integer.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6706().foob(i));
    }
}
