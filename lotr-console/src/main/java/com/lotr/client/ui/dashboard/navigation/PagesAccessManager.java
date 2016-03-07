package com.lotr.client.ui.dashboard.navigation;


import com.lotr.client.events.pages.OpenTabEvent;
import com.lotr.client.resources.Icons;
import com.lotr.client.resources.IconsFactory;

import java.util.ArrayList;
import java.util.List;

public class PagesAccessManager {

    public static List<NavigationItem> getNavigationItems() {
        List<NavigationItem> items = new ArrayList<>();
        Icons IconManager = IconsFactory.getIcons();
        items.add(new NavigationItem(OpenTabEvent.Tab.PRODUCTS_PAGE, "პროდუქტები", IconManager.offer()));
        items.add(new NavigationItem(OpenTabEvent.Tab.PRODUCT_GROUPS_PAGE, "პროდუქტის ჯგუფები", IconManager.controllers()));
        return items;
    }
}