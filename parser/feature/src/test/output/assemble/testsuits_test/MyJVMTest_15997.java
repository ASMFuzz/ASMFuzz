public class MyJVMTest_15997 {

    static byte num = 127;

    String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15997().byteToHex(num));
    }
}
