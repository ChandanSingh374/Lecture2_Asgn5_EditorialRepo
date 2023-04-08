import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;



public class MathTest {

    @Test
    public void testPiExists() {
        try {
            Field field = Math.class.getDeclaredField("PI");
            assertTrue(Modifier.isStatic(field.getModifiers()));
            assertEquals("double", field.getType().getSimpleName());
            assertEquals(3.14, field.getDouble(null), 0.0001);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Field PI does not exist or is not accessible");
        }
    }

    @Test
    public void testGetCircleAreaExists() {
        try {
            Method method = Math.class.getDeclaredMethod("getCircleArea", int.class);
            assertTrue(Modifier.isStatic(method.getModifiers()));
            assertEquals("double", method.getReturnType().getSimpleName());
        } catch (NoSuchMethodException e) {
            fail("Method getCircleArea does not exist");
        }
    }
//    @Test
//    public void testGetCircleArea() throws Exception {
//        Method getCircleArea = Math.class.getDeclaredMethod("getCircleArea", double.class);
//        getCircleArea.setAccessible(true);
//
//        double expectedArea = 78.5;
//        double actualArea = (double) getCircleArea.invoke(null, 5);
//        assertEquals(expectedArea, actualArea, 0.0001);
//    }
//
//    @Test
//    public void testGetCircleAreaZeroRadius() throws Exception {
//        Method getCircleArea = Math.class.getDeclaredMethod("getCircleArea", double.class);
//        getCircleArea.setAccessible(true);
//
//        double expectedArea = 0.0;
//        double actualArea = (double) getCircleArea.invoke(null, 0);
//        assertEquals(expectedArea, actualArea, 0.0001);
//    }
@Test
public void testGetCircleArea() throws Exception {
    Class<?> mathClass = Class.forName("Math");
    Field piField = mathClass.getDeclaredField("PI");
    piField.setAccessible(true);
    double pi = piField.getDouble(null);

    Method getCircleAreaMethod = mathClass.getDeclaredMethod("getCircleArea", int.class);
    getCircleAreaMethod.setAccessible(true);

    int radius = 5;
    double expectedArea = pi * radius * radius;
    double actualArea = (double) getCircleAreaMethod.invoke(null, radius);
    assertEquals(expectedArea, actualArea, 0.0001);
}

    @Test
    public void testGetCircleAreaZeroRadius() throws Exception {
        Class<?> mathClass = Class.forName("Math");
        Field piField = mathClass.getDeclaredField("PI");
        piField.setAccessible(true);
        double pi = piField.getDouble(null);

        Method getCircleAreaMethod = mathClass.getDeclaredMethod("getCircleArea", int.class);
        getCircleAreaMethod.setAccessible(true);

        int radius = 0;
        double expectedArea = pi * radius * radius;
        double actualArea = (double) getCircleAreaMethod.invoke(null, radius);
        assertEquals(expectedArea, actualArea, 0.0001);
    }


}
