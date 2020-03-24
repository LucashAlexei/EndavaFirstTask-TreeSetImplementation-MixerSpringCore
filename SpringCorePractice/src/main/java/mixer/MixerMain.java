package mixer;

import configuration.MixerConfig;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class MixerMain {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MixerConfig.class);

        Mixer mixer = context.getBean("mixer", Mixer.class);
        System.out.println(mixer.getState());

//        MixerConfig mc = context.getBean(MixerConfig.class);
//        mc.toString();

        MixerProducer mp = new MixerProducer("Sumsung", LocalDate.of(2009,06,15),"324252");
        System.out.println(mixer.getMixerProducerInformation(mp));


        context.close();
    }
}
