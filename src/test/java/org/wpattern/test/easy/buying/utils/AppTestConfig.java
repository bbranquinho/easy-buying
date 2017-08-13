package org.wpattern.test.easy.buying.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.wpattern.easy.buying.utils.AppConfig;

@Configuration
@Import(AppConfig.class)
public class AppTestConfig {
}
