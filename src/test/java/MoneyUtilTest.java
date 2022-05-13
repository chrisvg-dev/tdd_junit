import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilTest {

    /** ZONA DE PRUEBAS UNITARIAS */
    @Test
    public void moneyTest() {
        String money = MoneyUtil.format(1000);
        Assert.assertEquals( "$1000.00", money );
    }

    @Test
    public void negativeMoneyTest() {
        String money = MoneyUtil.format(-1000);
        Assert.assertEquals( "-$1000.00", money );
    }

    @Test
    public void euroMoneyTest() {
        String money = MoneyUtil.format(-1000);
        Assert.assertEquals( "-€1000.00", money );
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptioonMoneyTest() {
        MoneyUtil.format(-1000, null);
    }
    /** ZONA DE PRUEBAS UNITARIAS */

    /**
     * EL TDD ES DESARROLLO ORIENTADO A PRUEBAS
     * Tiene como objetivo hacer los tests y despues programar las funciones
     */

}
