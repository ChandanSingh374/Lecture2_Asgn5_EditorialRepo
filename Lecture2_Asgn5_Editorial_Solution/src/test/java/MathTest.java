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

    @Test
    public void testGetCircleArea() {
        double expectedArea = 78.5;
        double actualArea = Math.getCircleArea(5);
        assertEquals(expectedArea, actualArea, 0.0001);
    }

    @Test
    public void testGetCircleAreaZeroRadius() {
        double expectedArea = 0.0;
        double actualArea = Math.getCircleArea(0);
        assertEquals(expectedArea, actualArea, 0.0001);
    }

}

