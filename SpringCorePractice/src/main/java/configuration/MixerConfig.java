package configuration;

import enums.*;
import mixer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collections;

@Import(ValidationConfig.class)
@Configuration
@PropertySource("classpath:mixer.properties")
@EnableCaching
public class MixerConfig {

    @Value("${speed}")
    private String speedConfig ;

    @Value("${timer}")
    private String timerConfig;

    @Bean
    public SpeedEnum speed(){
        return SpeedEnum.chooseSpeed(speedConfig);
    }

    @Bean
    public TimerEnum timer(){
        return TimerEnum.chooseTime(timerConfig);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Mixer mixer(SpeedEnum speed, TimerEnum timer){
        return new Mixer(speed,timer);
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
