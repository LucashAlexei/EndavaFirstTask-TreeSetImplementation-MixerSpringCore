package myvalidator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class IDFormatTest {

    IDFormat idFormat = new IDFormat();

    @Test
    void shouldReturnFalseForShortId() {
        String tmp = "245";
        assertThat(idFormat.isValid(tmp, null)).isFalse();
    }

    @Test
    void shouldReturnFalseForLetterFormat(){
        String tmp = "mixer";
        assertThat(idFormat.isValid(tmp, null)).isFalse();
    }

    @Test
    void shouldReturnFalseForLetterWithNumbersFormat(){
        String tmp = "12mi3xer43";
        assertThat(idFormat.isValid(tmp, null)).isFalse();
    }

    @Test
    void shouldReturnFalseForEmptyNumberFormat(){
        assertThat(idFormat.isValid(null, null)).isFalse();
    }

    @Test
    void shouldReturnTrueForNumberFormat(){
        String tmp = "324252";
        assertThat(idFormat.isValid(tmp, null)).isTrue();
    }
}