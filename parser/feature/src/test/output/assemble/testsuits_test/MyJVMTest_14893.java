public class MyJVMTest_14893 {

    static Object o = 2;

    static int capacity = 8;

    static int chunk = 9;

    static Object[] array = {-1420395279,0,6,0,609755650,0,-461362974,-1358688073,0,4};

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
        new MyJVMTest_14893().store(o);
    }
}
