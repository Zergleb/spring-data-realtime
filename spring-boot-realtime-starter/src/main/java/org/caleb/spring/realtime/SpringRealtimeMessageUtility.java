package org.caleb.spring.realtime;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class SpringRealtimeMessageUtility {
	@Autowired
	public SimpMessagingTemplate template;

	public void sendEventMessage(Object item, final String verb) {
		final String model = item.getClass().getSimpleName().toLowerCase();
		String endPoint = String.format("/events/%s", model);
		template.convertAndSend(endPoint, item, new HashMap<String, Object>() {
			{
				put("model", model);
				put("verb", verb);
			}
		}, new MessagePostProcessor() {
			@Override
			public Message<?> postProcessMessage(Message<?> message) {
				return message;
			}
		});
	}
}