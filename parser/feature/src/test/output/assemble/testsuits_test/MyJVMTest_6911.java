public class MyJVMTest_6911 {

    static int i = 5;

    Integer foo(int i) {
        int dummyInt = i;
        return Integer.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6911().foo(i));
    }
}
