package mixer;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.validation.Validator;
import java.util.Collections;
import static org.mockito.Mockito.mock;


@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class CacheConfig {

    @Autowired
    Mixer mixer;
    @Autowired
    CacheManager cacheManager;

    @EnableCaching
    @Configuration
    public static class InnerCacheConfig {
        @Bean
        public CacheManager cacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("report")));
            return cacheManager;
        }

        @Bean
        public Mixer mixer() {
            return new Mixer(null, null, mock(Validator.class, Answers.RETURNS_SMART_NULLS));
        }
    }
}
