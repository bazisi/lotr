package com.lotr.client.ui.dashboard.navigation;

import com.google.gwt.resources.client.ImageResource;
import com.lotr.client.events.pages.OpenTabEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NavigationItem {

	private OpenTabEvent.Tab tab;
	
	private String title;
	
	private ImageResource icon;
	
	private List<NavigationItem> items = new ArrayList<>();

	private Map<String, Object> tabParams;
	
	public NavigationItem(OpenTabEvent.Tab tab, String title, ImageResource icon) {
		this.tab = tab;
		this.title = title;
		this.icon = icon;
	}
	
	public NavigationItem(OpenTabEvent.Tab tab, String title, ImageResource icon, List<NavigationItem> children) {
		this(tab, title, icon);
		this.items = children;
	}

	public OpenTabEvent.Tab getTab() {
		return tab;
	}

	public void setTab(OpenTabEvent.Tab tab) {
		this.tab = tab;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ImageResource getIcon() {
		return icon;
	}

	public void setIcon(ImageResource icon) {
		this.icon = icon;
	}

	public List<NavigationItem> getItems() {
		return items;
	}

	public void setItems(List<NavigationItem> items) {
		this.items = items;
	}

	public Map<String, Object> getTabParams() {
		return tabParams;
	}

	public void setTabParams(Map<String, Object> tabParams) {
		this.tabParams = tabParams;
	}
}