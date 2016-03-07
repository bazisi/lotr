package com.lotr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class ClientEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {
        ClientFactory clientFactory = new ClientFactory();
        AppController appController = new AppController(clientFactory);
        appController.go(RootLayoutPanel.get());
    }
}
