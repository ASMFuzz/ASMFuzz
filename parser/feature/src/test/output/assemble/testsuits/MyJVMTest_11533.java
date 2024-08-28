public class MyJVMTest_11533 {

    static int i = 2;

    Integer foo(int i) {
        int dummyInt = i;
        return new Integer(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11533().foo(i));
    }
}
