import java.lang.reflect.Field;

public class MyJVMTest_3807 {

    static Field f = null;

    Field verify(Field f) {
        try {
            if (!f.getBoolean(this)) {
                throw new RuntimeException(f.getName() + " notification is missed");
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3807().verify(f);
    }
}
