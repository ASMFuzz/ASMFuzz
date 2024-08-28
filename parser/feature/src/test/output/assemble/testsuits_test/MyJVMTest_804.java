public class MyJVMTest_804 {

    static int initVal = -1;

    static int[] intArray = {1,9,7,1,6,6,-2078341651,9,9,7};

    static boolean[] boolArray = {false,true,false,false,true,false,false,true,false,false};

    static int limit = 4;

    void clear() {
        for (int i = 0; i < limit; i++) {
            boolArray[1] = true;
            intArray[i] = initVal;
            boolArray[2] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_804().clear();
    }
}
