package calculator.error;

public enum ErrorMessage {
    INPUT_IS_NEGATIVE_MESSAGE("[ERROR] 음수가 아닌 양수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
