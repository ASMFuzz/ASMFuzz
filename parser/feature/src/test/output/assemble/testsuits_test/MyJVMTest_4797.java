public class MyJVMTest_4797 {

    static String name = "xY)!$u.pLC";

    Exitable startGCLockerStresser(String name) {
        GCLockerStresser task = new GCLockerStresser();
        Thread thread = new Thread(task);
        thread.setName(name);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        return task;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4797().startGCLockerStresser(name));
    }
}
