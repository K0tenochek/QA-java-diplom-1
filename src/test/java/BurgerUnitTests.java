import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitTests {
    public static final double DELTA = 0.0001;
    public static final float WHITE_BUN_PRICE = 1.6f;
    public static final float CHEESE_PRICE = 1.1f;
    public static final float CESAR_PRICE = 0.1f;
    @Mock
    public Bun whiteBun;

    @Mock
    public Ingredient cheese;

    @Mock
    public Ingredient cesar;

    @Before
    public void setUp() {
        Mockito.when(whiteBun.getPrice()).thenReturn(WHITE_BUN_PRICE);
        Mockito.when(cheese.getName()).thenReturn("cheese");
        Mockito.when(cesar.getName()).thenReturn("cesar");
        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cesar.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(cheese.getPrice()).thenReturn(CHEESE_PRICE);
        Mockito.when(cesar.getPrice()).thenReturn(CESAR_PRICE);
    }

    @Test
    public void getPriceForBunAndTwoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        burger.addIngredient(cheese);
        burger.addIngredient(cesar);
        float actualPrice = burger.getPrice();
        float expectedPrice = WHITE_BUN_PRICE * 2 + CHEESE_PRICE + CESAR_PRICE;
        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void getPriceForBunAndOneIngredient() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        burger.addIngredient(cheese);
        burger.addIngredient(cesar);
        burger.removeIngredient(1);
        float actualPrice = burger.getPrice();
        float expectedPrice = WHITE_BUN_PRICE * 2 + CHEESE_PRICE;
        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
        String expectedReceipt = "(==== null ====)\n= filling cheese =\n(==== null ====)\n\nPrice: 4,300000\n";
        System.out.println(burger.getReceipt());
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void getPriceForBunAndTwoIngredientsAfterMove() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        burger.addIngredient(cheese);
        burger.addIngredient(cesar);
        burger.moveIngredient(1, 0);
        float actualPrice = burger.getPrice();
        float expectedPrice = WHITE_BUN_PRICE * 2 + CHEESE_PRICE + CESAR_PRICE;
        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
        String expectedReceipt = "(==== null ====)\n= sauce cesar =\n= filling cheese =\n(==== null ====)\n" +
                "\nPrice: 4,400000\n";
        System.out.println(burger.getReceipt());
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }


}