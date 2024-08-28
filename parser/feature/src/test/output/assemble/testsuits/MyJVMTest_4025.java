public class MyJVMTest_4025 {

    static long payloadLength = 9223372036854775807L;

    IllegalArgumentException notMinimalEncoding(long payloadLength) {
        return new IllegalArgumentException("Not minimally-encoded payload length:" + payloadLength);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4025().notMinimalEncoding(payloadLength));
    }
}
