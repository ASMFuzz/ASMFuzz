public class MyJVMTest_6615 {

    static long negativeEvenNumber = -9223372036854775808L;

    long test(long negativeEvenNumber) {
        for (int i = 1; i <= 1; i++) {
            long leftShift = negativeEvenNumber << -i;
            long rightShift = negativeEvenNumber >>> i;
            if ((leftShift | rightShift) != (rightShift | leftShift)) {
                long or1 = leftShift | rightShift;
                long or2 = rightShift | leftShift;
                throw new RuntimeException("Or operations are not equal:" + " " + or1 + " vs. " + or2 + " - leftShift: " + leftShift + ", rightShift: " + rightShift);
            }
        }
        return negativeEvenNumber;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6615().test(negativeEvenNumber);
    }
}
