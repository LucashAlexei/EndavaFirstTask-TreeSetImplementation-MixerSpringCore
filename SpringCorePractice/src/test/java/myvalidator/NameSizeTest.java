package myvalidator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NameSizeTest {

    NameFormat nameformat = new NameFormat();

    @Test
    void shouldReturnFalseForIncorrectFormatOfName() {
        String tmp = "MSFASFASF";
        assertThat(nameformat.isValid(tmp, null)).isFalse();
    }

    @Test
    void shouldReturnFalseForEmptyFormatOfName() {
        assertThat(nameformat.isValid(null, null)).isFalse();
    }

    @Test
    void shouldReturnFalseForNumberFormatOfName() {
        String tmp = "3235235";
        assertThat(nameformat.isValid(tmp, null)).isFalse();
    }

    @Test
    void shouldReturnTrueForCorrectFormatOfName() {
        String tmp = "Philips";
        assertThat(nameformat.isValid(tmp, null)).isTrue();
    }
}