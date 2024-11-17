package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInputString() {
        System.out.println(ViewMessage.STRING_INPUT_MESSAGE);
        return Console.readLine();
    }
}
