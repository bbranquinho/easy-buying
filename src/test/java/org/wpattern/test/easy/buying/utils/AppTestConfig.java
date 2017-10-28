package org.wpattern.test.easy.buying.utils;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.wpattern.easy.buying.utils.AppConfig;

@SpringBootTest
@Configuration
@Import(value = { AppConfig.class } )
public class AppTestConfig {
}
