public class MyJVMTest_15502 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static Object[] theList = {0,5,7,1,-805090833,0,5,-747877404,0,315886691};

    static int[] theHashes = {6,0,0,2,-1108422202,0,9,3,245050664,9};

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
        new MyJVMTest_15502().run();
    }
}
