public class MyJVMTest_14814 {

    int returnOne() {
        int returnVal = -1;
        try {
            returnVal = 1 / 0;
        } catch (ArithmeticException e) {
            returnVal = 0;
        }
        try {
            returnVal = 10;
        } catch (NullPointerException e) {
            returnVal = -2;
        }
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14814().returnOne());
    }
}
