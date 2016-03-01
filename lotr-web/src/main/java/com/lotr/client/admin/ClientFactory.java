package com.lotr.client.admin;

import com.google.gwt.core.client.GWT;
import com.lotr.client.admin.resources.Icons;
import com.lotr.client.admin.ui.products.ProductsPage;

public class ClientFactory {

    private static final Icons ICONS = GWT.create(Icons.class);

    private static ProductsPage productsPage = null;

    public static Icons getIcons() {
        return ICONS;
    }

    public static ProductsPage getProductsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }
}