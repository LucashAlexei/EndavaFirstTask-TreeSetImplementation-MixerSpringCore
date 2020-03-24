package mixer;

import org.mockito.Answers;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collections;

import static org.mockito.Mockito.mock;

@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("report")));
        return cacheManager;
    }

    @Bean
    public Mixer mixer() {
        return new Mixer(null, null);//, mock(Validator.class, Answers.RETURNS_SMART_NULLS));
    }
}
