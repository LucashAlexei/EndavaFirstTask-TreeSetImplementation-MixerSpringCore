package myvalidator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NameSizeTest {

    @Mock
    ConstraintValidatorContext cvc;


    @InjectMocks
    NameFormat nameSize;  //validator


    @Test
    void shouldReturnFalseForIncorrectFormatOfName() {
        String tmp = "MSFASFASF";
        assertThat(nameSize.isValid(tmp, cvc)).isFalse();
    }

    @Test
    void shouldReturnFalseForEmptyFormatOfName() {
        assertThat(nameSize.isValid(null, cvc)).isFalse();
    }

    @Test
    void shouldReturnFalseForNumberFormatOfName() {
        String tmp = "3235235";
        assertThat(nameSize.isValid(tmp, cvc)).isFalse();
    }

    @Test
    void shouldReturnTrueForCorrectFormatOfName() {
        String tmp = "Philips";
        assertThat(nameSize.isValid(tmp, cvc)).isTrue();
    }
}