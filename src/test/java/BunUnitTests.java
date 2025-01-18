import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.asserts.SoftAssert;
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

    @Test
    public void checkNameAndPriceForBun() {
        SoftAssert softAssert = new SoftAssert();
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        float actualPrice = bun.getPrice();
        softAssert.assertEquals(name, actualName);
        softAssert.assertEquals(price, actualPrice, 0.0001);
        softAssert.assertAll();

    }
}

