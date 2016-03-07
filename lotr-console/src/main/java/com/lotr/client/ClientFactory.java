package com.lotr.client;

import com.google.gwt.core.client.GWT;
import com.lotr.client.resources.Icons;
import com.lotr.client.ui.products.ProductsPage;
import com.lotr.client.ui.productsgroups.ProductGroupsPage;

public class ClientFactory {

    private static final Icons ICONS = GWT.create(Icons.class);

    private static ProductsPage productsPage = null;
    private static ProductGroupsPage productGroupsPage = null;

    public static Icons getIcons() {
        return ICONS;
    }

    public static ProductsPage getProductsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public static ProductGroupsPage getProductGroupsPage() {
        if (productGroupsPage == null) {
            productGroupsPage = new ProductGroupsPage();
        }
        return productGroupsPage;
    }
}