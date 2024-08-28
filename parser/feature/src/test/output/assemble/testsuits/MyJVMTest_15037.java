public class MyJVMTest_15037 {

    static byte[] arr = { -105, 50, -64, -79, -89, 77, -125, 92, -110, -20 };

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
        System.out.println(new MyJVMTest_15037().byteArrayToHexString(arr));
    }
}
