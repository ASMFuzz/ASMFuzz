public class MyJVMTest_2858 {

    static int i = 116176133;

    int dummy(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2858().dummy(i));
    }
}
