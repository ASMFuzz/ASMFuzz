public class MyJVMTest_7874 {

    static long _beforeMillis = 0L;

    static long _afterMillis = 0L;

    static long _freeBytes = 0L;

    static long _totalBytes = 0L;

    static boolean _overflow = false;

    void epilogue() {
        _afterMillis = System.currentTimeMillis();
        if (_overflow) {
            System.out.println("Overflowed!");
        }
        final double deltaSecs = (_afterMillis - _beforeMillis) / 1000.0;
        final double freeMegs = ((double) _freeBytes) / (1024.0 * 1024.0);
        final double totalMegs = ((double) _totalBytes) / (1024.0 * 1024.0);
        final double memRatio = freeMegs / totalMegs;
        System.out.println("Runtime.freeMemory()/Runtime.totalMemory: " + Long.toString(_freeBytes) + "/" + Long.toString(_totalBytes) + " = " + Double.toString(memRatio));
        System.out.println("That took: " + Double.toString(deltaSecs) + " seconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7874().epilogue();
    }
}
