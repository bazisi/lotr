package com.lotr.client.events.pages;

import com.google.gwt.event.shared.GwtEvent;

import java.util.Map;

public class OpenTabEvent extends GwtEvent<OpenTabEventHandler> {

    public static Type<OpenTabEventHandler> TYPE = new Type<>();

    private Tab tab;
    private Map<String, Object> tabParams;

    public OpenTabEvent(Tab tab, Map<String, Object> tabParams) {
        this.tab = tab;
        this.tabParams = tabParams;
    }

    @Override
    protected void dispatch(OpenTabEventHandler openTabEventHandler) {
        openTabEventHandler.onOpenTabEvent(tab, tabParams);
    }

    @Override
    public Type<OpenTabEventHandler> getAssociatedType() {
        return TYPE;
    }

    public enum Tab {
        PRODUCTS_PAGE,
        PRODUCT_GROUPS_PAGE
    }
}