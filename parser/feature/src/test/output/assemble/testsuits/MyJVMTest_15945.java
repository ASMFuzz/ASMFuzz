import java.util.Vector;

public class MyJVMTest_15945 {

    int getSize() {
        int size = 10;
        Vector<String> vector = new Vector<String>();
        for (int i = 0; i < size; i++) {
            vector.add("String-" + i);
        }
        return vector.size();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15945().getSize());
    }
}
