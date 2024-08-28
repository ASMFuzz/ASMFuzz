import javax.xml.stream.EventFilter;

public class MyJVMTest_2253 {

    static int type = -167943001;

    static boolean[] types = new boolean[20];

    int addType(int type) {
        types[type] = true;
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2253().addType(type);
    }
}
