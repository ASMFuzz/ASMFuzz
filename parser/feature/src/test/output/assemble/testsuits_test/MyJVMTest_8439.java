public class MyJVMTest_8439 {

    static int negativeEvenNumber = 7;

    int test(int negativeEvenNumber) {
        for (int i = 1; i <= 1; i++) {
            int leftShift = negativeEvenNumber << -i;
            int rightShift = negativeEvenNumber >>> i;
            if ((leftShift | rightShift) != (rightShift | leftShift)) {
                int or1 = leftShift | rightShift;
                int or2 = rightShift | leftShift;
                throw new RuntimeException("Or operations are not equal:" + " " + or1 + " vs. " + or2 + " - leftShift: " + leftShift + ", rightShift: " + rightShift);
            }
        }
        return negativeEvenNumber;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8439().test(negativeEvenNumber);
    }
}
