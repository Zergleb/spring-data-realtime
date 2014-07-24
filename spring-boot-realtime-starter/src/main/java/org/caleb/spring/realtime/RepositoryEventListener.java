package org.caleb.spring.realtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

public class RepositoryEventListener extends AbstractRepositoryEventListener {
	@Autowired
	private SpringRealtimeMessageUtility utility = new SpringRealtimeMessageUtility();

	@Override
	public void onAfterCreate(Object item) {
		utility.sendEventMessage(item, "create");
	}

	@Override
	public void onAfterDelete(Object item) {
		utility.sendEventMessage(item, "delete");
	}

	@Override
	public void onAfterSave(Object item) {
		utility.sendEventMessage(item, "update");
	}

}
