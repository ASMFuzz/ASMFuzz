public class MyJVMTest_14983 {

    Runnable m() {
        int i = 3;
        return new Runnable() {

            public void run() {
                System.out.println(i);
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14983().run();
    }
}
