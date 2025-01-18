import org.junit.Test;
import praktikum.IngredientType;

import static org.testng.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void checkSizeIngredientsType() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length, "Enum should contain exactly two elements.");
    }
}
