package mixer;

import enums.SpeedEnum;
import enums.TimerEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Mixer {

    private SpeedEnum speed;
    private TimerEnum timer;

    public String getState(){
        return "-----------------\nSpeed: " + speed + "\nTimer: " + timer + "\n-----------------";
    }

    @Cacheable("report")
    public String getMixerProducerInformation(@Valid MixerProducer mixerProducer){
            return "---------------------------\nProducer: " + mixerProducer.getProducerName() + "\nProduce Date: " + mixerProducer.getProduceDate()
                    + "\nMixer ID: " + mixerProducer.getIdMixer() + "\n---------------------------";
    }
}
