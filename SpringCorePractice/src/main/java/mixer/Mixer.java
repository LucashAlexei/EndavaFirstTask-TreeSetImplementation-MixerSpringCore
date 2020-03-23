package mixer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class Mixer {

    Speed speed;
    Timer timer;
    Validator validator;

    public String getState(){
        return "-----------------\nSpeed: " + speed.getSpeedEnum() + "\nTimer: " + timer.getTimerEnum() + "\n-----------------";
    }

    @Cacheable("report")
    public String getMixerProducerInformation(MixerProducer mixerProducer){
        Set<ConstraintViolation<MixerProducer>> validate = validator.validate(mixerProducer);
        if(!validate.isEmpty()){
            for(ConstraintViolation<MixerProducer> i : validate){
                System.out.println("-----------------------\nDetails: " + i.getMessage() + " Invalid Value: " + i.getInvalidValue());
            }
            return "Incorrect Format.\n-----------------------";
        }
        else{
            return "---------------------------\nProducer: " + mixerProducer.getProducerName() + "\nProduce Date: " + mixerProducer.getProduceDate()
                    + "\nMixer ID: " + mixerProducer.getIdMixer() + "\n---------------------------";
        }
    }
}
