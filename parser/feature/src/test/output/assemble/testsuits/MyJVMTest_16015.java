import java.awt.geom.AffineTransform;

public class MyJVMTest_16015 {

    static float[] atParam1 = { 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, 0.9401262f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static AffineTransform at = new AffineTransform(atParam1);

    static int TYPE_IDENTITY = AffineTransform.TYPE_IDENTITY;

    static int TYPE_TRANSLATION = AffineTransform.TYPE_TRANSLATION;

    static int TYPE_UNIFORM_SCALE = AffineTransform.TYPE_UNIFORM_SCALE;

    static int TYPE_GENERAL_SCALE = AffineTransform.TYPE_GENERAL_SCALE;

    static int TYPE_FLIP = AffineTransform.TYPE_FLIP;

    static int TYPE_QUADRANT_ROTATION = AffineTransform.TYPE_QUADRANT_ROTATION;

    static int TYPE_GENERAL_ROTATION = AffineTransform.TYPE_GENERAL_ROTATION;

    static int TYPE_GENERAL_TRANSFORM = AffineTransform.TYPE_GENERAL_TRANSFORM;

    int getRefType(AffineTransform at) {
        double m00 = at.getScaleX();
        double m11 = at.getScaleY();
        double m01 = at.getShearX();
        double m10 = at.getShearY();
        if (m00 * m01 + m10 * m11 != 0) {
            return TYPE_GENERAL_TRANSFORM;
        }
        int type = ((at.getTranslateX() != 0 || at.getTranslateY() != 0) ? TYPE_TRANSLATION : TYPE_IDENTITY);
        boolean sgn0, sgn1;
        if (m01 == 0 && m10 == 0) {
            sgn0 = (m00 >= 0.0);
            sgn1 = (m11 >= 0.0);
            if (sgn0 == sgn1) {
                if (sgn0) {
                    if (m00 != m11) {
                        type |= TYPE_GENERAL_SCALE;
                    } else if (m00 != 1.0) {
                        type |= TYPE_UNIFORM_SCALE;
                    }
                } else {
                    type |= TYPE_QUADRANT_ROTATION;
                    if (m00 != m11) {
                        type |= TYPE_GENERAL_SCALE;
                    } else if (m00 != -1.0) {
                        type |= TYPE_UNIFORM_SCALE;
                    }
                }
            } else {
                type |= TYPE_FLIP;
                if (m00 != -m11) {
                    type |= TYPE_GENERAL_SCALE;
                } else if (m00 != 1.0 && m00 != -1.0) {
                    type |= TYPE_UNIFORM_SCALE;
                }
            }
        } else if (m00 == 0 && m11 == 0) {
            sgn0 = (m01 >= 0.0);
            sgn1 = (m10 >= 0.0);
            if (sgn0 != sgn1) {
                if (m01 != -m10) {
                    type |= (TYPE_QUADRANT_ROTATION | TYPE_GENERAL_SCALE);
                } else if (m01 != 1.0 && m01 != -1.0) {
                    type |= (TYPE_QUADRANT_ROTATION | TYPE_UNIFORM_SCALE);
                } else {
                    type |= TYPE_QUADRANT_ROTATION;
                }
            } else {
                if (m01 == m10) {
                    if (m01 == 0) {
                        type |= TYPE_UNIFORM_SCALE;
                    } else {
                        type |= (TYPE_QUADRANT_ROTATION | TYPE_FLIP | TYPE_UNIFORM_SCALE);
                    }
                } else {
                    type |= (TYPE_QUADRANT_ROTATION | TYPE_FLIP | TYPE_GENERAL_SCALE);
                }
            }
        } else {
            if (m00 * m11 >= 0.0) {
                if (m00 != m11 || m01 != -m10) {
                    type |= (TYPE_GENERAL_ROTATION | TYPE_GENERAL_SCALE);
                } else if (m00 == 0) {
                    if (m01 == -m10) {
                        type |= (TYPE_QUADRANT_ROTATION | TYPE_UNIFORM_SCALE);
                    } else {
                        type |= (TYPE_QUADRANT_ROTATION | TYPE_GENERAL_SCALE);
                    }
                } else if (m00 * m11 - m01 * m10 != 1.0) {
                    type |= (TYPE_GENERAL_ROTATION | TYPE_UNIFORM_SCALE);
                } else {
                    type |= TYPE_GENERAL_ROTATION;
                }
            } else {
                if (m00 != -m11 || m01 != m10) {
                    type |= (TYPE_GENERAL_ROTATION | TYPE_FLIP | TYPE_GENERAL_SCALE);
                } else if (m01 == 0) {
                    if (m00 == 1.0 || m00 == -1.0) {
                        type |= TYPE_FLIP;
                    } else {
                        type |= (TYPE_FLIP | TYPE_UNIFORM_SCALE);
                    }
                } else if (m00 * m11 - m01 * m10 != 1.0) {
                    type |= (TYPE_GENERAL_ROTATION | TYPE_FLIP | TYPE_UNIFORM_SCALE);
                } else {
                    type |= (TYPE_GENERAL_ROTATION | TYPE_FLIP);
                }
            }
        }
        return type;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16015().getRefType(at));
    }
}
