public class MyJVMTest_17364 {

    static int expectedline = 5;

    static T7024096 args = null;

    T7024096 nest(int expectedline, T7024096... args) {
        Exception e = new Exception("expected line#: " + expectedline);
        int myline = e.getStackTrace()[1].getLineNumber();
        if (myline != expectedline) {
            throw new RuntimeException("Incorrect line number " + "expected: " + expectedline + ", got: " + myline, e);
        }
        System.out.format("Got expected line number %d correct %n", myline);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17364().nest(expectedline, args));
    }
}
