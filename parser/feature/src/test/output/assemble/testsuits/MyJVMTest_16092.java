public class MyJVMTest_16092 {

    long count() {
        for (final Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals("Direct Clip")) {
                return t.getId();
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16092().count());
    }
}
