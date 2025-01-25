import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunUnitTests {
    private final String name;
    private final float price;


    public BunUnitTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAndPrice() {
        return new Object[][]{
                {"Black", 4.5f},
                {"White", 6.0f},
                {"", -5.0f},
                {null, 0},
                {"BlackAndWhiteBlackAndWhiteBlackAndWhiteBlackAndWhiteBlackAndWhiteBlackAndWhite", 0.01f},
                {"BlackAndWhite#1", 1000.0f},
        };
    }

    private static final float DELTA = 0.0001f;

    @Test
    public void checkNameAndPriceForBun() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        float actualPrice = bun.getPrice();
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice, DELTA);

    }
}

