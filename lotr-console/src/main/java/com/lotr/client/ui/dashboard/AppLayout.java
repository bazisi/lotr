package com.lotr.client.ui.dashboard;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AppLayout {

	private BorderLayoutContainer blc;

	private TabPanel tabPanel;

	public void go(HasWidgets container) {
		initUI();
		container.add(blc);
	}

	public void createTabItem(Widget widget, String title, ImageResource icon, boolean closable, boolean openMultiple) {
		Widget tabWidget = null;
		if (!openMultiple) {
			tabWidget = findTabWidget(title);
		}
		if (tabWidget == null) {
			TabItemConfig conf = new TabItemConfig();
			conf.setText(title);
			conf.setIcon(icon);
			conf.setClosable(closable);
			tabWidget = widget;
			tabPanel.add(widget, conf);
		}
		tabPanel.setActiveWidget(tabWidget);
	}

	private void initUI() {
		blc = new BorderLayoutContainer();

		BorderLayoutContainer.BorderLayoutData northData = new BorderLayoutContainer.BorderLayoutData();
		northData.setSize(40);

		BorderLayoutContainer.BorderLayoutData southData = new BorderLayoutContainer.BorderLayoutData();
		southData.setSize(15);

//		blc.setNorthWidget(new HeaderPanel(), northData);
//		blc.setSouthWidget(new FooterPanel(), southData);
		blc.setCenterWidget(getTabPanel());
	}

	private TabPanel getTabPanel() {
		tabPanel = new TabPanel(){
			boolean closeAllTabIsAdded = false;

			@Override
			protected void onItemContextMenu(Widget item, int x, int y) {
				super.onItemContextMenu(item, x, y);
				if (!closeAllTabIsAdded) {
					closeContextMenu.add(new MenuItem("closeAllTab", new SelectionHandler<MenuItem>() {
						@Override
						public void onSelection(SelectionEvent<MenuItem> event) {
							List<Widget> widgets = new ArrayList<>();
							for (int i = 0, len = getWidgetCount(); i < len; i++) {
								widgets.add(getWidget(i));
							}

							for (Widget w : widgets) {
								TabItemConfig config = getConfig(w);
								if (config.isClosable()) {
									close(w);
								}
							}
						}
					}));
					closeAllTabIsAdded = true;
				}
				MenuItem mi = (MenuItem) closeContextMenu.getWidget(2);
				mi.setEnabled(getWidgetCount() > 2);
				closeContextMenu.showAt(x, y);
			}
		};

		tabPanel.setAnimScroll(true);
		//tabPanel.setHeight(44);
		tabPanel.setTabScroll(true);
		tabPanel.setCloseContextMenu(true);
		tabPanel.setAutoSelect(true);
		tabPanel.setMessages(new TabPanel.TabPanelMessages() {
			@Override
			public String closeOtherTabs() {
				return "closeOtherTabs";
			}

			@Override
			public String closeTab() {
				return "closeThisTab";
			}
		});
		createTabItem(new DashBoard(), "main", null, false, false);
		return tabPanel;
	}

	public Widget findTabWidget(String title) {
		for (int i = 0; i < tabPanel.getWidgetCount(); i++) {
			TabItemConfig conf = tabPanel.getConfig(tabPanel.getWidget(i));
			if (conf.getText().equals(title)) {
				return tabPanel.getWidget(i);
			}
		}
		return null;
	}

}