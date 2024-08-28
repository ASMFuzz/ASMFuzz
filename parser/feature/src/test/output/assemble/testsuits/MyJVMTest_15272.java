public class MyJVMTest_15272 {

    static int[] a = {2,4,-234358053,8,4,-311667323,0,7,1,5};

    static Iterable<Integer> b = null;

    void testIterable() {
        for (Integer b : b) {
            Integer b2 = b;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15272().testIterable();
    }
}
