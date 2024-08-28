public class MyJVMTest_10701 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static Object[] theList = {1,3,6,0,1,0,0,0,5,7};

    static int count = 0;

    void run() {
        while (!ExternalHashingTest.startingGun) {
            ExternalHashingTest.pause();
        }
        for (int i = 0; i < theList.length; i++) {
            synchronized (theList[i]) {
                count++;
            }
        }
        ExternalHashingTest.finishLocking = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10701().run();
    }
}
