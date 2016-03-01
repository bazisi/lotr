package com.lotr.client.admin.events.pages;

import com.google.gwt.event.shared.EventHandler;

import java.util.Map;

public interface OpenTabEventHandler extends EventHandler {

	void onOpenTabEvent(OpenTabEvent.Tab tab, Map<String, Object> tabParams);
}