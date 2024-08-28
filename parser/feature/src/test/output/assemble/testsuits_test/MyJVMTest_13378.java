public class MyJVMTest_13378 {

    static long payloadLength = 0;

    IllegalArgumentException notMinimalEncoding(long payloadLength) {
        return new IllegalArgumentException("Not minimally-encoded payload length:" + payloadLength);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13378().notMinimalEncoding(payloadLength));
    }
}
