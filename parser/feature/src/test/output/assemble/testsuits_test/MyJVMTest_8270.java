public class MyJVMTest_8270 {

    static int index = 0;

    static int value = 79624897;

    static int[] indexed = {0,0,3,9,1726006901,-1963398690,2062213083,7,2,33997337};

    int setIndexed(int index, int value) {
        this.indexed[index] = value;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8270().setIndexed(index, value);
    }
}
