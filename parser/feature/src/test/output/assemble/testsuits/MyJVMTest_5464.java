public class MyJVMTest_5464 {

    static Object o = 1187451470;

    static int capacity = 942736508;

    static int chunk = 0;

    static Object[] array = {1,0,3,9,6,-620860745,736472473,0,0,0};

    static int index = 0;

    Object store(Object o) {
        if (array == null) {
            throw new RuntimeException("Capacity should be set before storing");
        }
        array[index % capacity] = o;
        ++index;
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5464().store(o);
    }
}
