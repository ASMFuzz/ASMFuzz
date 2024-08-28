public class MyJVMTest_8643 {

    static int i = 7;

    Integer foo(int i) {
        int dummyInt = i;
        return Integer.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8643().foo(i));
    }
}
