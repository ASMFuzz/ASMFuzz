public class MyJVMTest_1236 {

    static int index = 1;

    static int[] indexed = {9,0,4,4,1908335786,8,5,3,4,1};

    int getIndexed(int index) {
        return this.indexed[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1236().getIndexed(index));
    }
}
