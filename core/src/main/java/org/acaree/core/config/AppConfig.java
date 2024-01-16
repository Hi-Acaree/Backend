package org.acaree.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class is a configuration class for the core module.
 * @Configuration annotation to mark the class as a configuration class.
 * @ComponentScan annotation to scan the packages for components.
 */

@Configuration
@ComponentScan(basePackages = {"org.acaree.core, org.acaree.core.repository, " +
        "org.acaree.core.service, org.acaree.core.model"})
public class AppConfig {
}
