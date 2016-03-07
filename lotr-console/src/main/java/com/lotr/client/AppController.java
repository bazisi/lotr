package com.lotr.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.lotr.client.events.pages.OpenTabEvent;
import com.lotr.client.events.pages.OpenTabEventHandler;
import com.lotr.client.ui.dashboard.AppLayout;
import com.lotr.client.ui.products.ProductsPage;
import com.lotr.client.ui.productsgroups.ProductGroupsPage;
import com.sencha.gxt.widget.core.client.container.Viewport;

import java.util.Map;

public class AppController {

    public static final Viewport VIEWPORT = new Viewport();
    public static final HandlerManager EVENT_BUS = new HandlerManager(null);
    //    public static Map<Integer, ControllerResourcePrototypeDTO> RESOURCE_TYPES;
    private static AppLayout appLayout;
    private ClientFactory clientFactory;


    public AppController(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
//        bindMessageEventListener();
    }

    public void go(final HasWidgets container) {
//        ServicesFactory.getUserService().loadInitialData(new ServiceCallback<InitialDataDTO>() {
//            @Override
//            public void onServiceSuccess(InitialDataDTO result) {
        bind();
        appLayout = new AppLayout();
        appLayout.go(VIEWPORT);
        container.add(VIEWPORT);
//            }
//        });
    }

    private void bind() {
        EVENT_BUS.addHandler(OpenTabEvent.TYPE, new OpenTabEventHandler() {
            @Override
            public void onOpenTabEvent(OpenTabEvent.Tab tab, Map<String, Object> tabParams) {
                switch (tab) {
                    case PRODUCTS_PAGE:
                        productsPage();
                        break;
                    case PRODUCT_GROUPS_PAGE:
                        productGroupsPage();
                        break;
                }
            }
        });
    }

    private void productsPage() {
        appLayout.createTabItem(new ProductsPage(), "პროდუქტები", ClientFactory.getIcons().offer(), true, false);
    }

    private void productGroupsPage() {
        appLayout.createTabItem(new ProductGroupsPage(), "პროდუქტის ჯგუფები", ClientFactory.getIcons().controllers(), true, false);
    }
}