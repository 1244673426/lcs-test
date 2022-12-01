package com.lcs.lcsboot.config;

import com.lcs.lcsboot.constant.RedisConstants;
import com.lcs.lcsboot.enums.BusinessTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class BusinessNoGenerator {

    private final RedisTemplate redisTemplate;

    /**
     * @param businessType 业务类型枚举
     * @param digit        业务序号位数
     * @return
     */
    public String generate(BusinessTypeEnum businessType, Integer digit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        String key = RedisConstants.BUSINESS_NO_PREFIX + businessType.getValue() + ":" + date;
        Long increment = redisTemplate.opsForValue().increment(key);
        return date + businessType.getValue() + String.format("%0" + digit + "d", increment);
    }

    public String generate(BusinessTypeEnum businessType) {
        Integer defaultDigit = 6;
        return generate(businessType, defaultDigit);
    }

}
