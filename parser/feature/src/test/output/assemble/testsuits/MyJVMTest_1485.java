public class MyJVMTest_1485 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static Object[] theList = {41886207,7,283718977,0,0,0,9,1,-608291171,1406981884};

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
        new MyJVMTest_1485().run();
    }
}
