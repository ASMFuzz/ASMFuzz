public class MyJVMTest_6622 {

    int testExtraParens() {
        int failures = 1;
        String s = "first";
        switch(s) {
            case (("first")):
                failures = 0;
                break;
            case ("second"):
                throw new RuntimeException("Should not be reached.");
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6622().testExtraParens());
    }
}
