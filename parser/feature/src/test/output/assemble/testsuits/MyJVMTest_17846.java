public class MyJVMTest_17846 {

    static int index = 0;

    static int value = 0;

    static int[] indexed = {8,0,6,4,0,2096367845,0,0,4,4};

    int setIndexed(int index, int value) {
        this.indexed[index] = value;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17846().setIndexed(index, value);
    }
}
