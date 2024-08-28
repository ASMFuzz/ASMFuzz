public class MyJVMTest_16421 {

    static int i = 0;

    Integer foo(int i) {
        int dummyInt = i;
        return Integer.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16421().foo(i));
    }
}
