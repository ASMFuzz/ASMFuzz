import java.lang.reflect.Field;

public class MyJVMTest_9476 {

    static Field f = null;

    static int i = 554300008;

    Field setVal(Field f, int i) {
        try {
            if (f.getType() == int.class) {
                f.setInt(this, i);
                return;
            } else if (f.getType() == short.class) {
                f.setShort(this, (short) i);
                return;
            } else if (f.getType() == byte.class) {
                f.setByte(this, (byte) i);
                return;
            } else if (f.getType() == long.class) {
                f.setLong(this, i);
                return;
            }
        } catch (IllegalAccessException iae) {
            throw new RuntimeException("Getting fields failed");
        }
        throw new RuntimeException("unexpected field type");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9476().setVal(f, i);
    }
}
