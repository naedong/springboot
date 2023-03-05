package kr.co.e4net.respository;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class Redis {

    private final String PREFIX = "sms:";  // (1)
    private final int LIMIT_TIME = 3 * 60;  // (2)

    private final StringRedisTemplate redisTemplate;

    public void createSmsCertification(String phone, String certificationNumber) { //(3)
    	redisTemplate.opsForValue()
            .set(PREFIX + phone, certificationNumber, Duration.ofSeconds(LIMIT_TIME));
    }

    public String getSmsCertification(String phone) { // (4)
        return redisTemplate.opsForValue().get(PREFIX + phone);
    }

    public Boolean removeSmsCertification(String phone) { // (5)
    		return redisTemplate.delete(PREFIX + phone);
    }

    public boolean hasKey(String phone) {  //(6)
        return redisTemplate.hasKey(PREFIX + phone);
    }
}