public class MyJVMTest_17303 {

    static int i = 9;

    int ival(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17303().ival(i));
    }
}
