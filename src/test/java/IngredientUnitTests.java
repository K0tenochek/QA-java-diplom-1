import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientUnitTests {


    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientUnitTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeNamePrice() {
        return new Object[][]{
                {IngredientType.FILLING, "Chicken", 8.0f},
                {IngredientType.SAUCE, "Beef", 10.0f}
        };
    }

    @Test
    public void checkTypeOfIngredients() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }

    @Test
    public void checkNameOfIngredients() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void checkPriceOfIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0001);
    }
}
