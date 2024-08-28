public class MyJVMTest_14368 {

    static Runnable[] r = {null,null,null,null,null,null,null,null,null,null};

    Runnable getFirstRunnable() {
        return r[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14368().getFirstRunnable());
    }
}
