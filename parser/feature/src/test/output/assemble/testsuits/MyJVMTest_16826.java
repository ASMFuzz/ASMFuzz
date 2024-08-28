public class MyJVMTest_16826 {

    static int count = 0;

    static Counter initialState = null;

    int increment() {
        return ++count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16826().increment());
    }
}
