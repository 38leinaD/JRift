package de.fruitfly.ovr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: Engineer
 * Date: 4/13/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class EyeRenderParams
{
    public float _renderScale;
    public float _XCenterOffset;
    public int _leftViewPortX, _leftViewPortY, _leftViewPortW, _leftViewPortH;
    public float[][] _leftProjectionM;
    public float[][] _leftViewAdjustM;
    public int _rightViewPortX, _rightViewPortY, _rightViewPortW, _rightViewPortH;
    public float[][] _rightProjectionM;
    public float[][] _rightViewAdjustM;
    public float _halfIPD;

    public EyeRenderParams(float renderScale, float xCentreOffset,
                           int leftViewPortX, int leftViewPortY, int leftViewPortW, int leftViewPortH,
                           float leftProjectionM00, float leftProjectionM01, float leftProjectionM02, float leftProjectionM03,
                           float leftProjectionM10, float leftProjectionM11, float leftProjectionM12, float leftProjectionM13,
                           float leftProjectionM20, float leftProjectionM21, float leftProjectionM22, float leftProjectionM23,
                           float leftProjectionM30, float leftProjectionM31, float leftProjectionM32, float leftProjectionM33,
                           float leftViewAdjustM00, float leftViewAdjustM01, float leftViewAdjustM02, float leftViewAdjustM03,
                           float leftViewAdjustM10, float leftViewAdjustM11, float leftViewAdjustM12, float leftViewAdjustM13,
                           float leftViewAdjustM20, float leftViewAdjustM21, float leftViewAdjustM22, float leftViewAdjustM23,
                           float leftViewAdjustM30, float leftViewAdjustM31, float leftViewAdjustM32, float leftViewAdjustM33,
                           int rightViewPortX, int rightViewPortY, int rightViewPortW, int rightViewPortH,
                           float rightProjectionM00, float rightProjectionM01, float rightProjectionM02, float rightProjectionM03,
                           float rightProjectionM10, float rightProjectionM11, float rightProjectionM12, float rightProjectionM13,
                           float rightProjectionM20, float rightProjectionM21, float rightProjectionM22, float rightProjectionM23,
                           float rightProjectionM30, float rightProjectionM31, float rightProjectionM32, float rightProjectionM33,
                           float rightViewAdjustM00, float rightViewAdjustM01, float rightViewAdjustM02, float rightViewAdjustM03,
                           float rightViewAdjustM10, float rightViewAdjustM11, float rightViewAdjustM12, float rightViewAdjustM13,
                           float rightViewAdjustM20, float rightViewAdjustM21, float rightViewAdjustM22, float rightViewAdjustM23,
                           float rightViewAdjustM30, float rightViewAdjustM31, float rightViewAdjustM32, float rightViewAdjustM33)
    {
        _leftProjectionM = new float[4][4];
        _leftViewAdjustM = new float[4][4];
        _rightProjectionM = new float[4][4];
        _rightViewAdjustM = new float[4][4];

        _renderScale = renderScale;
        _XCenterOffset = xCentreOffset;

        _leftViewPortX = leftViewPortX; _leftViewPortY = leftViewPortY; _leftViewPortW = leftViewPortW; _leftViewPortH = leftViewPortH;
        _leftProjectionM[0][0] = leftProjectionM00; _leftProjectionM[0][1] = leftProjectionM01; _leftProjectionM[0][2] = leftProjectionM02; _leftProjectionM[0][3] = leftProjectionM03;
        _leftProjectionM[1][0] = leftProjectionM10; _leftProjectionM[1][1] = leftProjectionM11; _leftProjectionM[1][2] = leftProjectionM12; _leftProjectionM[1][3] = leftProjectionM13;
        _leftProjectionM[2][0] = leftProjectionM20; _leftProjectionM[2][1] = leftProjectionM21; _leftProjectionM[2][2] = leftProjectionM22; _leftProjectionM[2][3] = leftProjectionM23;
        _leftProjectionM[3][0] = leftProjectionM30; _leftProjectionM[3][1] = leftProjectionM31; _leftProjectionM[3][2] = leftProjectionM32; _leftProjectionM[3][3] = leftProjectionM33;
        _leftViewAdjustM[0][0] = leftViewAdjustM00; _leftViewAdjustM[0][1] = leftViewAdjustM01; _leftViewAdjustM[0][2] = leftViewAdjustM02; _leftViewAdjustM[0][3] = leftViewAdjustM03;
        _leftViewAdjustM[1][0] = leftViewAdjustM10; _leftViewAdjustM[1][1] = leftViewAdjustM11; _leftViewAdjustM[1][2] = leftViewAdjustM12; _leftViewAdjustM[1][3] = leftViewAdjustM13;
        _leftViewAdjustM[2][0] = leftViewAdjustM20; _leftViewAdjustM[2][1] = leftViewAdjustM21; _leftViewAdjustM[2][2] = leftViewAdjustM22; _leftViewAdjustM[2][3] = leftViewAdjustM23;
        _leftViewAdjustM[3][0] = leftViewAdjustM30; _leftViewAdjustM[3][1] = leftViewAdjustM31; _leftViewAdjustM[3][2] = leftViewAdjustM32; _leftViewAdjustM[3][3] = leftViewAdjustM33;

        _rightViewPortX = rightViewPortX; _rightViewPortY = rightViewPortY; _rightViewPortW = rightViewPortW; _rightViewPortH = rightViewPortH;
        _rightProjectionM[0][0] = rightProjectionM00; _rightProjectionM[0][1] = rightProjectionM01; _rightProjectionM[0][2] = rightProjectionM02; _rightProjectionM[0][3] = rightProjectionM03;
        _rightProjectionM[1][0] = rightProjectionM10; _rightProjectionM[1][1] = rightProjectionM11; _rightProjectionM[1][2] = rightProjectionM12; _rightProjectionM[1][3] = rightProjectionM13;
        _rightProjectionM[2][0] = rightProjectionM20; _rightProjectionM[2][1] = rightProjectionM21; _rightProjectionM[2][2] = rightProjectionM22; _rightProjectionM[2][3] = rightProjectionM23;
        _rightProjectionM[3][0] = rightProjectionM30; _rightProjectionM[3][1] = rightProjectionM31; _rightProjectionM[3][2] = rightProjectionM32; _rightProjectionM[3][3] = rightProjectionM33;
        _rightViewAdjustM[0][0] = rightViewAdjustM00; _rightViewAdjustM[0][1] = rightViewAdjustM01; _rightViewAdjustM[0][2] = rightViewAdjustM02; _rightViewAdjustM[0][3] = rightViewAdjustM03;
        _rightViewAdjustM[1][0] = rightViewAdjustM10; _rightViewAdjustM[1][1] = rightViewAdjustM11; _rightViewAdjustM[1][2] = rightViewAdjustM12; _rightViewAdjustM[1][3] = rightViewAdjustM13;
        _rightViewAdjustM[2][0] = rightViewAdjustM20; _rightViewAdjustM[2][1] = rightViewAdjustM21; _rightViewAdjustM[2][2] = rightViewAdjustM22; _rightViewAdjustM[2][3] = rightViewAdjustM23;
        _rightViewAdjustM[3][0] = rightViewAdjustM30; _rightViewAdjustM[3][1] = rightViewAdjustM31; _rightViewAdjustM[3][2] = rightViewAdjustM32; _rightViewAdjustM[3][3] = rightViewAdjustM33;

        _halfIPD = leftViewAdjustM03;
    }

    public FloatBuffer gl_getLeftProjectionMatrix()
    {
        FloatBuffer buf = createFloatBuffer(16);

        // Transposed
        buf.put(_leftProjectionM[0][0]);buf.put(_leftProjectionM[1][0]);buf.put(_leftProjectionM[2][0]);buf.put(_leftProjectionM[3][0]);
        buf.put(_leftProjectionM[0][1]);buf.put(_leftProjectionM[1][1]);buf.put(_leftProjectionM[2][1]);buf.put(_leftProjectionM[3][1]);
        buf.put(_leftProjectionM[0][2]);buf.put(_leftProjectionM[1][2]);buf.put(_leftProjectionM[2][2]);buf.put(_leftProjectionM[3][2]);
        buf.put(_leftProjectionM[0][3]);buf.put(_leftProjectionM[1][3]);buf.put(_leftProjectionM[2][3]);buf.put(_leftProjectionM[3][3]);
        buf.flip();

        return buf;
    }

    public FloatBuffer gl_getRightProjectionMatrix()
    {
        FloatBuffer buf = createFloatBuffer(16);

        // Transposed
        buf.put(_rightProjectionM[0][0]);buf.put(_rightProjectionM[1][0]);buf.put(_rightProjectionM[2][0]);buf.put(_rightProjectionM[3][0]);
        buf.put(_rightProjectionM[0][1]);buf.put(_rightProjectionM[1][1]);buf.put(_rightProjectionM[2][1]);buf.put(_rightProjectionM[3][1]);
        buf.put(_rightProjectionM[0][2]);buf.put(_rightProjectionM[1][2]);buf.put(_rightProjectionM[2][2]);buf.put(_rightProjectionM[3][2]);
        buf.put(_rightProjectionM[0][3]);buf.put(_rightProjectionM[1][3]);buf.put(_rightProjectionM[2][3]);buf.put(_rightProjectionM[3][3]);
        buf.flip();

        return buf;
    }

    public FloatBuffer gl_getLeftViewportTransform()
    {
        FloatBuffer buf = createFloatBuffer(16);

        // Transposed
        buf.put(_leftViewAdjustM[0][0]);buf.put(_leftViewAdjustM[1][0]);buf.put(_leftViewAdjustM[2][0]);buf.put(_leftViewAdjustM[3][0]);
        buf.put(_leftViewAdjustM[0][1]);buf.put(_leftViewAdjustM[1][1]);buf.put(_leftViewAdjustM[2][1]);buf.put(_leftViewAdjustM[3][1]);
        buf.put(_leftViewAdjustM[0][2]);buf.put(_leftViewAdjustM[1][2]);buf.put(_leftViewAdjustM[2][2]);buf.put(_leftViewAdjustM[3][2]);
        buf.put(_leftViewAdjustM[0][3]);buf.put(_leftViewAdjustM[1][3]);buf.put(_leftViewAdjustM[2][3]);buf.put(_leftViewAdjustM[3][3]);
        buf.flip();

        return buf;
    }

    public FloatBuffer gl_getRightViewportTransform()
    {
        FloatBuffer buf = createFloatBuffer(16);

//        System.out.println("Right viewport transform:");
//        System.out.println(String.format("[%.5f] [%.5f] [%.5f] [%.5f]", new Object[] {Float.valueOf(_rightViewAdjustM[0][0]), Float.valueOf(_rightViewAdjustM[0][1]), Float.valueOf(_rightViewAdjustM[0][2]), Float.valueOf(_rightViewAdjustM[0][3])}));
//        System.out.println(String.format("[%.5f] [%.5f] [%.5f] [%.5f]", new Object[] {Float.valueOf(_rightViewAdjustM[1][0]), Float.valueOf(_rightViewAdjustM[1][1]), Float.valueOf(_rightViewAdjustM[1][2]), Float.valueOf(_rightViewAdjustM[1][3])}));
//        System.out.println(String.format("[%.5f] [%.5f] [%.5f] [%.5f]", new Object[] {Float.valueOf(_rightViewAdjustM[2][0]), Float.valueOf(_rightViewAdjustM[2][1]), Float.valueOf(_rightViewAdjustM[2][2]), Float.valueOf(_rightViewAdjustM[2][3])}));
//        System.out.println(String.format("[%.5f] [%.5f] [%.5f] [%.5f]", new Object[] {Float.valueOf(_rightViewAdjustM[3][0]), Float.valueOf(_rightViewAdjustM[3][1]), Float.valueOf(_rightViewAdjustM[3][2]), Float.valueOf(_rightViewAdjustM[3][3])}));

        // Transposed
        buf.put(_rightViewAdjustM[0][0]);buf.put(_rightViewAdjustM[1][0]);buf.put(_rightViewAdjustM[2][0]);buf.put(_rightViewAdjustM[3][0]);
        buf.put(_rightViewAdjustM[0][1]);buf.put(_rightViewAdjustM[1][1]);buf.put(_rightViewAdjustM[2][1]);buf.put(_rightViewAdjustM[3][1]);
        buf.put(_rightViewAdjustM[0][2]);buf.put(_rightViewAdjustM[1][2]);buf.put(_rightViewAdjustM[2][2]);buf.put(_rightViewAdjustM[3][2]);
        buf.put(_rightViewAdjustM[0][3]);buf.put(_rightViewAdjustM[1][3]);buf.put(_rightViewAdjustM[2][3]);buf.put(_rightViewAdjustM[3][3]);
        buf.flip();

        return buf;
    }

    public static synchronized ByteBuffer createByteBuffer(int size)
    {
        return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
    }

    public static IntBuffer createIntBuffer(int size)
    {
        return createByteBuffer(size << 2).asIntBuffer();
    }

    public static FloatBuffer createFloatBuffer(int size)
    {
        return createByteBuffer(size << 2).asFloatBuffer();
    }

    public static FloatBuffer createMatrix4f(float m0, float m1, float m2, float m3,
                                             float m4, float m5, float m6, float m7,
                                             float m8, float m9, float m10, float m11,
                                             float m12, float m13, float m14, float m15)
    {
        FloatBuffer buf = EyeRenderParams.createFloatBuffer(16);
        buf.put(m0);buf.put(m1);buf.put(m2);buf.put(m3);
        buf.put(m4);buf.put(m5);buf.put(m6);buf.put(m7);
        buf.put(m8);buf.put(m9);buf.put(m10);buf.put(m11);
        buf.put(m12);buf.put(m13);buf.put(m14);buf.put(m15);
        buf.flip();
        return buf;
    }

    public static String Matrix4fToString(FloatBuffer buf)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("[%.5f] [%.5f] [%.5f] [%.5f]\n", new Object[] {Float.valueOf(buf.get(0)), Float.valueOf(buf.get(4)), Float.valueOf(buf.get(8)), Float.valueOf(buf.get(12))}));
        builder.append(String.format("[%.5f] [%.5f] [%.5f] [%.5f]\n", new Object[] {Float.valueOf(buf.get(1)), Float.valueOf(buf.get(5)), Float.valueOf(buf.get(9)), Float.valueOf(buf.get(13))}));
        builder.append(String.format("[%.5f] [%.5f] [%.5f] [%.5f]\n", new Object[] {Float.valueOf(buf.get(2)), Float.valueOf(buf.get(6)), Float.valueOf(buf.get(10)), Float.valueOf(buf.get(14))}));
        builder.append(String.format("[%.5f] [%.5f] [%.5f] [%.5f]\n", new Object[] {Float.valueOf(buf.get(3)), Float.valueOf(buf.get(7)), Float.valueOf(buf.get(11)), Float.valueOf(buf.get(15))}));
        return builder.toString();
    }
}
