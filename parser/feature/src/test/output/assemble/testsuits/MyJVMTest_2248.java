public class MyJVMTest_2248 {

    static int i = -2035899453;

    static byte[] array = {-33,-53,-18,35,23,7,-47,9,108,-66};

    String getString(int i) {
        return "A" + i + "B";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2248().getString(i));
    }
}
