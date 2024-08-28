public class MyJVMTest_14196 {

    static String name = "*f?dPYy/%w";

    Exitable startGCLockerStresser(String name) {
        GCLockerStresser task = new GCLockerStresser();
        Thread thread = new Thread(task);
        thread.setName(name);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        return task;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14196().startGCLockerStresser(name));
    }
}
