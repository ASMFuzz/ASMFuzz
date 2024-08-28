public class MyJVMTest_3937 {

    static Object fromValue = 5;

    static Class<?> toType = null;

    Object convert(Object fromValue, Class<?> toType) {
        Class<?> fromType = fromValue.getClass();
        if (Byte.class.equals(fromType) && toType.equals(byte.class))
            return fromValue;
        if (Short.class.equals(fromType) && toType.equals(short.class))
            return fromValue;
        if (Byte.class.equals(fromType) && toType.equals(short.class))
            return Short.valueOf((short) ((Byte) fromValue).byteValue());
        if (Integer.class.equals(fromType) && toType.equals(int.class))
            return fromValue;
        if (Byte.class.equals(fromType) && toType.equals(int.class))
            return Integer.valueOf((int) ((Byte) fromValue).byteValue());
        if (Short.class.equals(fromType) && toType.equals(int.class))
            return Integer.valueOf((int) ((Short) fromValue).shortValue());
        if (Character.class.equals(fromType) && toType.equals(int.class))
            return Integer.valueOf((int) ((Character) fromValue).charValue());
        if (Long.class.equals(fromType) && toType.equals(long.class))
            return fromValue;
        if (Byte.class.equals(fromType) && toType.equals(long.class))
            return Long.valueOf((long) ((Byte) fromValue).byteValue());
        if (Short.class.equals(fromType) && toType.equals(long.class))
            return Long.valueOf((long) ((Short) fromValue).shortValue());
        if (Character.class.equals(fromType) && toType.equals(long.class))
            return Long.valueOf((long) ((Character) fromValue).charValue());
        if (Integer.class.equals(fromType) && toType.equals(long.class))
            return Long.valueOf((long) ((Integer) fromValue).intValue());
        if (Float.class.equals(fromType) && toType.equals(float.class))
            return fromValue;
        if (Byte.class.equals(fromType) && toType.equals(float.class))
            return Float.valueOf((float) ((Byte) fromValue).byteValue());
        if (Short.class.equals(fromType) && toType.equals(float.class))
            return Float.valueOf((float) ((Short) fromValue).shortValue());
        if (Character.class.equals(fromType) && toType.equals(float.class))
            return Float.valueOf((float) ((Character) fromValue).charValue());
        if (Integer.class.equals(fromType) && toType.equals(float.class))
            return Float.valueOf((float) ((Integer) fromValue).intValue());
        if (Long.class.equals(fromType) && toType.equals(float.class))
            return Float.valueOf((float) ((Long) fromValue).longValue());
        if (Double.class.equals(fromType) && toType.equals(double.class))
            return fromValue;
        if (Byte.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Byte) fromValue).byteValue());
        if (Short.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Short) fromValue).shortValue());
        if (Character.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Character) fromValue).charValue());
        if (Integer.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Integer) fromValue).intValue());
        if (Long.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Long) fromValue).longValue());
        if (Float.class.equals(fromType) && toType.equals(double.class))
            return Double.valueOf((double) ((Float) fromValue).floatValue());
        throw new IllegalArgumentException("Can't convert [" + fromValue + "] to " + toType);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3937().convert(fromValue, toType));
    }
}
