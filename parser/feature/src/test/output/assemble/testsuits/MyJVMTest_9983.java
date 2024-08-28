public class MyJVMTest_9983 {

    static int initVal = -1;

    static int[] intArray = {0,9,0,1,1499777623,3,-148913618,2,8,3};

    static boolean[] boolArray = {false,false,true,false,true,true,false,false,false,true};

    static int limit = -370603815;

    void clear() {
        for (int i = 0; i < limit; i++) {
            boolArray[1] = true;
            intArray[i] = initVal;
            boolArray[2] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9983().clear();
    }
}
