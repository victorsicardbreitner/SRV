package org.biblicontrib.biblisecurity.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("withSecurity")
public class MySecurityDefaultConfig {
	
	@Bean
	@ConditionalOnMissingBean(type= { "org.biblicontrib.biblisecurity.config.MySecuritySimpleConfigurer"})
	MySecuritySimpleConfigurer  defaultMySecuritySimpleConfigurer(BCryptPasswordEncoder passwordEncoder) {
		return new MySecuritySimpleConfigurerDefaultImpl(passwordEncoder);
	}

}
