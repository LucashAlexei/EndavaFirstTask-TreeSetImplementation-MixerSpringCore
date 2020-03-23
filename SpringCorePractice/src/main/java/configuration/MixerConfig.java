package configuration;

import enums.*;
import mixer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collections;

@Configuration
@PropertySource("classpath:Mixer.properties")
@EnableCaching
public class MixerConfig {

    @Value("${Speed}")
    private String speedConfig;

    @Value("${Timer}")
    private String timerConfig;

    @Bean
    public Speed speed(){
        Speed speed = new Speed();
        speed.setSpeedEnum(SpeedEnum.chooseSpeed(speedConfig));
        return speed;
    }

    @Bean
    public Timer timer(){
        Timer timer = new Timer();
        timer.setTimerEnum(TimerEnum.chooseTime(timerConfig));
        return timer;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Mixer mixer(Speed speed, Timer timer,Validator validator){
        return new Mixer(speed,timer,validator);
    }

    @Bean
    public Validator validator(){
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("report")));
        return cacheManager;
    }
}
