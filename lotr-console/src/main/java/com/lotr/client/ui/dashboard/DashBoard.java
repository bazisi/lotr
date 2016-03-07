package com.lotr.client.ui.dashboard;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.lotr.client.AppController;
import com.lotr.client.events.pages.OpenTabEvent;
import com.lotr.client.ui.dashboard.navigation.NavigationItem;
import com.lotr.client.ui.dashboard.navigation.NavigationSeparator;
import com.lotr.client.ui.dashboard.navigation.PagesAccessManager;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoard extends Composite {

    FlowLayoutContainer layoutContainer;

    private Map<Anchor,Menu> menuList = new HashMap<>();

    public DashBoard() {
        initUI();
    }

    private void initUI() {
        layoutContainer = new FlowLayoutContainer();
        layoutContainer.setScrollMode(ScrollSupport.ScrollMode.AUTO);
        List<NavigationItem> items = PagesAccessManager.getNavigationItems();
        for (NavigationItem parentItem : items) {
            if (!(parentItem instanceof NavigationSeparator)) {
                if (!(parentItem.getItems().size() > 0)) {
                    addItem(parentItem);
                } else{
                    addMenu(parentItem);
                }
            }
        }
        initWidget(layoutContainer);
    }

    private void addItem(final NavigationItem navigationItem){
        final Anchor link = new Anchor(AbstractImagePrototype.create(navigationItem.getIcon()).getHTML() + " " + navigationItem.getTitle(), true);
        link.addStyleName("dashboard-quicklink-block");
        link.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent arg0) {
                AppController.EVENT_BUS.fireEvent(new OpenTabEvent(navigationItem.getTab(), navigationItem.getTabParams()));
            }
        });
        link.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent mouseOverEvent) {
                for (Anchor anchor : menuList.keySet()) {
                    menuList.get(anchor).hide();
                }
            }
        });
        layoutContainer.add(link);
    }

    private void addMenu(final NavigationItem navigationItem){
        final Anchor link = new Anchor(AbstractImagePrototype.create(navigationItem.getIcon()).getHTML()  + " " + navigationItem.getTitle(), true);
        final Menu menu = new Menu();
        menuList.put(link, menu);
        link.addStyleName("dashboard-quicklink-block");
        link.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent arg0) {
                menu.show(link);
            }
        });
        link.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent mouseOverEvent) {
                for (Anchor anchor : menuList.keySet()) {
                    menuList.get(anchor).hide();
                }
                menu.show(link);
            }
        });
        fillMenuItemsRecursively(menu, navigationItem);
        layoutContainer.add(link);
    }

    private void fillMenuItemsRecursively(Menu menu, NavigationItem item) {
        for (final NavigationItem child : item.getItems()) {
            MenuItem subMenuItem = new MenuItem();
            subMenuItem.setIcon(child.getIcon());
            subMenuItem.setText(child.getTitle());
            subMenuItem.setWidth(218);
            subMenuItem.addSelectionHandler(new SelectionHandler<Item>() {
                @Override
                public void onSelection(SelectionEvent<Item> itemSelectionEvent) {

                    AppController.EVENT_BUS.fireEvent(new OpenTabEvent(child.getTab(), child.getTabParams()));

                }
            });
            Menu subMenu = new Menu();
            fillMenuItemsRecursively(subMenu, child);
            if (subMenu.getWidgetCount() != 0) {
                subMenuItem.setSubMenu(subMenu);
            }
            menu.add(subMenuItem);
        }
    }

}