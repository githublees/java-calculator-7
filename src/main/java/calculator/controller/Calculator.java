package calculator.controller;

import calculator.domain.Calculate;
import calculator.util.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calculate calculate = new Calculate(new Separator());
        int result = calculate.addition(inputView.getInputString());
        outputView.printResult(result);
    }
}
