public class MyJVMTest_11787 {

    static boolean thread_started = false;

    static boolean do_load = false;

    static boolean load_done = false;

    void run() {
        thread_started = true;
        while (!do_load) ;
        new B();
        load_done = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11787().run();
    }
}
