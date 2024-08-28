import java.lang.reflect.Field;

public class MyJVMTest_9793 {

    static Field f = null;

    int getVal(Field f) {
        try {
            if (f.getType() == int.class) {
                return f.getInt(this);
            } else if (f.getType() == short.class) {
                return (int) f.getShort(this);
            } else if (f.getType() == byte.class) {
                return (int) f.getByte(this);
            } else if (f.getType() == long.class) {
                return (int) f.getLong(this);
            }
        } catch (IllegalAccessException iae) {
            throw new RuntimeException("Setting fields failed");
        }
        throw new RuntimeException("unexpected field type");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9793().getVal(f));
    }
}
