package org.caleb.spring.realtime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebSocketConfig.class)
public class SpringMVCRealtimeConfiguration {
	@Bean
	public RepositoryEventListener repositoryEventListener() {
		return new RepositoryEventListener();
	}

	@Bean
	public SpringRealtimeMessageUtility springRealtimeMessageUtility() {
		return new SpringRealtimeMessageUtility();
	}
}
