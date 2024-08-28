public class MyJVMTest_5601 {

    static byte[] arr = { -14, -23, -34, -24, -56, -26, 123, -96, -51, 66 };

    String byteArrayToHexString(byte[] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            byte curVal = arr[i];
            result.append(Character.forDigit(curVal >> 4 & 0xF, 16));
            result.append(Character.forDigit(curVal & 0xF, 16));
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5601().byteArrayToHexString(arr));
    }
}
