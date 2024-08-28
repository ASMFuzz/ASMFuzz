public class MyJVMTest_10436 {

    static int index = 3;

    static int[] indexed = {5,2,5,806247633,0,3,-1387739805,5,0,-1484250410};

    int getIndexed(int index) {
        return this.indexed[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10436().getIndexed(index));
    }
}
