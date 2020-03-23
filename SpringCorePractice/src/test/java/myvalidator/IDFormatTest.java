package myvalidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IDFormatTest {

    @Mock
    ConstraintValidatorContext cvc;

    @InjectMocks
    IDFormat idFormat; //validator

    @Test
    void shouldReturnFalseForShortId() {
        String tmp = "245";
        assertThat(idFormat.isValid(tmp, cvc)).isFalse();
    }

    @Test
    void shouldReturnFalseForLetterFormat(){
        String tmp = "mixer";
        assertThat(idFormat.isValid(tmp, cvc)).isFalse();
    }

    @Test
    void shouldReturnFalseForLetterWithNumbersFormat(){
        String tmp = "12mi3xer43";
        assertThat(idFormat.isValid(tmp, cvc)).isFalse();
    }

    @Test
    void shouldReturnFalseForEmptyNumberFormat(){
        assertThat(idFormat.isValid(null, cvc)).isFalse();
    }

    @Test
    void shouldReturnTrueForNumberFormat(){
        String tmp = "324252";
        assertThat(idFormat.isValid(tmp, cvc)).isTrue();
    }
}