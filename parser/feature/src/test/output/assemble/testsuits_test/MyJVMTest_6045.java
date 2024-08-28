public class MyJVMTest_6045 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static Object[] theList = {0,5,0,0,-1184985192,6,1483990465,0,0,1504135004};

    static int[] theHashes = {0,-1616312759,7,1550952569,8,0,4,-414718371,1834518733,-1468373102};

    void run() {
        while (!ExternalHashingTest.startingGun) {
            ExternalHashingTest.pause();
        }
        for (int i = 0; i < theList.length; i++) {
            theHashes[i] = theList[i].hashCode();
        }
        ExternalHashingTest.finishHashing = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6045().run();
    }
}
