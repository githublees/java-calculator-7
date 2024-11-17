package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final Pattern pattern = Pattern.compile(Delimiter.CUSTOM_DELIMITER.getDelimiter());

    public String[] customSplit(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String content = matcher.group(2);
            return content.split(Pattern.quote(delimiter));
        }
        return input.split(Delimiter.DEFAULT_DELIMITER.getDelimiter());
    }
}
