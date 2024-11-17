package calculator;

import calculator.controller.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(new InputView(), new OutputView());
        calculator.run();
    }
}
