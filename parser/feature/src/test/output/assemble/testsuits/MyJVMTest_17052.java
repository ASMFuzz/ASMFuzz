public class MyJVMTest_17052 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {3,5,0,0,6,7,-1644845205,2,5,0};

    int last() {
        return a.length - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17052().last());
    }
}
