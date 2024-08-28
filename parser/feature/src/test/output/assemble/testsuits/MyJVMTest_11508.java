import javax.xml.stream.EventFilter;

public class MyJVMTest_11508 {

    static int type = 0;

    static boolean[] types = new boolean[20];

    int addType(int type) {
        types[type] = true;
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11508().addType(type);
    }
}
