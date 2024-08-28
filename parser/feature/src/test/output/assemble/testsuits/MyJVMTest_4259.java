public class MyJVMTest_4259 {

    static long payloadLength = 9223372036854775807L;

    IllegalArgumentException negativePayload(long payloadLength) {
        return new IllegalArgumentException("Negative payload length: " + payloadLength);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4259().negativePayload(payloadLength));
    }
}
