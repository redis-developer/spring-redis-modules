package com.redislabs.springredismodules;

import com.redislabs.mesclun.RedisModulesClient;
import com.redislabs.mesclun.StatefulRedisModulesConnection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class RedisModulesAutoConfigurationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner().withConfiguration(AutoConfigurations.of(RedisModulesAutoConfiguration.class));

    @Test
    void testDefaultRedisModulesConfiguration() {
        this.contextRunner.run((context) -> {
            assertThat(context.getBean("client")).isInstanceOf(RedisModulesClient.class);
            assertThat(context).hasSingleBean(RedisModulesClient.class);
            assertThat(context).hasSingleBean(StatefulRedisModulesConnection.class);
        });
    }

}