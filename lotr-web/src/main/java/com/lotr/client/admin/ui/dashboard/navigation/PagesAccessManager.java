package com.lotr.client.admin.ui.dashboard.navigation;


import com.lotr.client.admin.events.pages.OpenTabEvent;
import com.lotr.client.admin.resources.Icons;
import com.lotr.client.admin.resources.IconsFactory;

import java.util.ArrayList;
import java.util.List;

public class PagesAccessManager {

    public static List<NavigationItem> getNavigationItems() {
        List<NavigationItem> items = new ArrayList<>();
        Icons IconManager = IconsFactory.getIcons();
        items.add(new NavigationItem(OpenTabEvent.Tab.PRODUCTS_PAGE, "products", IconManager.products()));
        return items;
    }
}