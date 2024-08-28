public class MyJVMTest_7300 {

    static int count = 0;

    static Counter initialState = null;

    int increment() {
        return ++count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7300().increment());
    }
}
