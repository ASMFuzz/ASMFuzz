public class MyJVMTest_14611 {

    static int expectedline = 0;

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
        new MyJVMTest_14611().assertLine(expectedline);
    }
}
