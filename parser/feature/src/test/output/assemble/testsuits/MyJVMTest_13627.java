public class MyJVMTest_13627 {

    static long payloadLength = 0;

    IllegalArgumentException negativePayload(long payloadLength) {
        return new IllegalArgumentException("Negative payload length: " + payloadLength);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13627().negativePayload(payloadLength));
    }
}
