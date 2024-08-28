public class MyJVMTest_11564 {

    static Counter initialState = null;

    Object initialSnapshot() {
        if (initialState == null) {
            throw new IllegalStateException("attempting initialSnapshot with null");
        }
        return initialState;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11564().initialSnapshot());
    }
}
