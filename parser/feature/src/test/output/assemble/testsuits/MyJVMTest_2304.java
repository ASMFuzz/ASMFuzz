public class MyJVMTest_2304 {

    static Counter initialState = null;

    Object initialSnapshot() {
        if (initialState == null) {
            throw new IllegalStateException("attempting initialSnapshot with null");
        }
        return initialState;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2304().initialSnapshot());
    }
}
