package mixer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {CacheConfig.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class MixerTest {

    @InjectMocks
    @Autowired
    Mixer mixerCache;

    @Mock
    MixerProducer mp;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    static Validator validatorTest;

    @InjectMocks
    Mixer mixer;

    static Validator validator;

    @BeforeAll
    private static void validationFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldReturnCountOfSyntaxErrorsInProducerDetailsEqualsTo3() {
        MixerProducer mp = new MixerProducer("sumsung", LocalDate.of(2023, 6, 15), "3");
        Set<ConstraintViolation<MixerProducer>> validate1 = validator.validate(mp);
        assertThat(validate1.size()).isEqualTo(3);
    }

    @Test
    void shouldReturnCountOfSyntaxErrorsInProducerDetailsEqualsTo0() {
        MixerProducer mp = new MixerProducer("Lg", LocalDate.of(2015, 6, 15), "6454577");
        Set<ConstraintViolation<MixerProducer>> validate2 = validator.validate(mp);
        assertThat(validate2.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnExpectedStringAfterValidation() {
        MixerProducer mp = new MixerProducer("Lg", LocalDate.of(2015, 6, 15), "6454577");
        assertThat(mixer.getMixerProducerInformation(mp)).isEqualTo("---------------------------\nProducer: " + "Lg" +
                "\nProduce Date: " + "2015-06-15"
                + "\nMixer ID: " + "6454577" + "\n---------------------------");
    }

    @Test
    void shouldReturnInvocationNumberToCacheMethodEqualToOne() {
        mixerCache.getMixerProducerInformation(mp);
        mixerCache.getMixerProducerInformation(mp);
        mixerCache.getMixerProducerInformation(mp);
        Mockito.verify(mp, Mockito.times(1)).getIdMixer();
    }
}