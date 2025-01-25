import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;



public class IngredientTypeTest {
    @Test
    public void checkSizeIngredientsType() {
        IngredientType[] values = IngredientType.values();
        Assert.assertEquals(2, values.length);
    }
}
