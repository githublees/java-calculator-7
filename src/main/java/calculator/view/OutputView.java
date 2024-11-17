package calculator.view;

public class OutputView {

    public void printResult(int input) {
        System.out.println(ViewMessage.STRING_RESULT_MESSAGE.format(input));
    }
}
