public class MyJVMTest_9117 {

    boolean isRVObserver() {
        Exception e = new Exception();
        for (StackTraceElement elem : e.getStackTrace()) {
            if (elem.getClassName().endsWith("ObserverCache")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9117().isRVObserver());
    }
}
