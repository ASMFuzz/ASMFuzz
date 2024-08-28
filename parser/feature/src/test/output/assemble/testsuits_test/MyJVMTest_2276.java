public class MyJVMTest_2276 {

    static int i = 0;

    Integer foo(int i) {
        int dummyInt = i;
        return new Integer(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2276().foo(i));
    }
}
