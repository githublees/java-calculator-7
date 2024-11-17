package calculator.domain;

import calculator.error.ErrorMessage;
import calculator.util.Separator;
import java.util.Arrays;

public class Calculate {
    private final Separator separator;

    public Calculate(Separator separator) {
        this.separator = separator;
    }

    public int addition(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return Arrays.stream(separator.customSplit(input))
                .mapToInt(Integer::parseInt)
                .peek(Calculate::validateNegative)
                .sum();
    }

    private static void validateNegative(int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NEGATIVE_MESSAGE.getMessage());
        }
    }

    private static boolean isNegative(int number) {
        return number <= 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
