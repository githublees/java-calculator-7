package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.util.Separator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculateTest {

    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate(new Separator());
    }

    @Test
    void 추출한_문자열_빈칸_테스트() {
        assertThat(calculate.addition("")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void 기본_구분자_테스트(String input) {
        assertThat(calculate.addition(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//abc\\n1abc2abc3", "//0\\n10203", "//]\\n1]2]3"})
    void 커스텀_구분자_테스트(String input) {
        assertThat(calculate.addition(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\\n123", "//;\\n1;2//.\\n;3"})
    void 커스텀_구분자_예외_테스트(String input) {
        assertThatThrownBy(() -> calculate.addition(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_예외_테스트() {
        assertThatThrownBy(() -> calculate.addition("-1,2,-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}