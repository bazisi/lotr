package com.lotr.client.ui.products;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class ProductsPage extends Composite{


    ToolBar toolBar;
    VerticalLayoutContainer controlPanel;

    public ProductsPage() {
        init();
        initWidget(controlPanel);
        controlPanel.add(toolBar);
        VerticalLayoutContainer vlc = new VerticalLayoutContainer();
        vlc.setScrollMode(ScrollSupport.ScrollMode.ALWAYS);
        controlPanel.add(vlc, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        vlc.setBorders(true);
    }

    private void init() {
        toolBar = new ToolBar();
        toolBar.add(new TextField());
        toolBar.add(new Button("ძებნა"));
        toolBar.add(new Button("დამატება"));

        createGrid();
        controlPanel = new VerticalLayoutContainer();
        controlPanel.setBorders(true);
        controlPanel.getElement().getStyle().setBackgroundColor("white");
    }

    private void createGrid() {

    }
}
