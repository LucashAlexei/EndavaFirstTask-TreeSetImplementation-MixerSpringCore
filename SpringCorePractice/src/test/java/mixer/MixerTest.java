package mixer;

import enums.SpeedEnum;
import enums.TimerEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class MixerTest extends CacheConfig {
    @Mock
    Timer timer;
    //@Mock Timer timer = Timer timer = Mockito.mock(Timer.class)
    @Mock
    Speed speed;

    private MixerProducer mp = new
            MixerProducer("sumsung", LocalDate.of(2023, 6, 15), "3");

    static Validator validator;

    @BeforeAll
    private static void validationFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldGetMixerStateDetails() {
        when(speed.getSpeedEnum()).thenReturn(SpeedEnum.HIGHT);
        when(timer.getTimerEnum()).thenReturn(TimerEnum.MINUTES_2);
        assertThat(speed.getSpeedEnum()).isEqualTo(SpeedEnum.HIGHT);
        assertThat(timer.getTimerEnum()).isEqualTo(TimerEnum.MINUTES_2);
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
    void shouldReturnCacheEqualToOne() {
        mixer.getMixerProducerInformation(mp);
        mixer.getMixerProducerInformation(mp);
        mixer.getMixerProducerInformation(mp);
        ConcurrentMap cache = (ConcurrentMap) cacheManager.getCache("report").getNativeCache();
        assertThat(cache).hasSize(1);
    }

}