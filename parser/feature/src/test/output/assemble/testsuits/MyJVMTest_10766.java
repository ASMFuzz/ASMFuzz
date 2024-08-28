public class MyJVMTest_10766 {

    int getReadOnly() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10766().getReadOnly());
    }
}
