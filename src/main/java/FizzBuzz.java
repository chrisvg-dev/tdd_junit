import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++){
            numbers.add(getNumber(i));
        }
        return numbers;
    }

    private String getNumber(int i) {
        if (isBoolean(i, 3) && isBoolean(i, 5)) {
            return FIZZ_BUZZ;
        }
        if (isBoolean(i, 3)) {
            return FIZZ;
        }
        if (isBoolean(i, 5)) {
            return BUZZ;
        }
        return i+"";
    }

    public boolean isBoolean(int value, int multiple) {
        if (value % multiple == 0) return true;
        return false;
    }
}
