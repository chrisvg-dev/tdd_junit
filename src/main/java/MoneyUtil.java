import java.math.BigDecimal;

/**
 * PARA PRUEBAS UNITARIAS
 */
public class MoneyUtil {

    private MoneyUtil(){}

    public static String format(double money) {
        return format(money, "$");
    }

    public static String format(double money, String symbol) {

        if (symbol == null) throw new IllegalArgumentException("");

        if (money < 0) {
            symbol = "-" + symbol;
            money *= (-1);
        }
        BigDecimal rounded = BigDecimal.valueOf(money).setScale(2, BigDecimal.ROUND_HALF_UP);
        return symbol + rounded;
    }

}
