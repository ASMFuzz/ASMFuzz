public class MyJVMTest_5195 {

    static int expectedline = 6;

    int assertLine(int expectedline) {
        Exception e = new Exception("expected line#: " + expectedline);
        int myline = e.getStackTrace()[2].getLineNumber();
        if (myline != expectedline) {
            throw new RuntimeException("Incorrect line number " + "expected: " + expectedline + ", got: " + myline, e);
        }
        System.out.format("Got expected line number %d correct %n", myline);
        return myline;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5195().assertLine(expectedline);
    }
}
