package calculator.view;

public enum ViewMessage {
    STRING_INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    STRING_RESULT_MESSAGE("결과 : %d");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

    @Override
    public String toString() {
        return message;
    }
}
