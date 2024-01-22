package org.acaree.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class is a configuration class for the core module.
 * {@code @Configuration} annotation to indicate that this class is a configuration class.
 * {@code @ComponentScan} annotation to indicate the packages to be scanned for components.
 */

@Configuration
@ComponentScan(basePackages = {"org.acaree.core.repository, " +
        "org.acaree.core.service, org.acaree.core.model"})
public class AppConfig {
}
