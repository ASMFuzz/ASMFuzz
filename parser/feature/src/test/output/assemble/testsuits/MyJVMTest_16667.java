public class MyJVMTest_16667 {

    static int len = 0;

    static String[] garbage_array = {"4p3dLD&#!&","Je/OA<Ht1[","B-yxBffvE3","jtu&u>uUU:","8agy'mB%m\\"," {orV\\T~b4","UX,M(=z42@","fF$1]-Cg>k","<'2UT>W6\"^","VP>dL1[1R5"};

    int create_garbage(int len) {
        len = Math.max(len, 1024);
        String[] array = new String[len];
        for (int index = 0; index < len; index++) {
            array[index] = "String " + index;
        }
        garbage_array = array;
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16667().create_garbage(len);
    }
}
