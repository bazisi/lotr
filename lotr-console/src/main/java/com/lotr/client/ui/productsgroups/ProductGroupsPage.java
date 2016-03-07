package com.lotr.client.ui.productsgroups;

import com.google.gwt.user.client.ui.Button;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class ProductGroupsPage extends Composite {


    ToolBar toolBar;
    VerticalLayoutContainer controlPanel;

    public ProductGroupsPage() {
        init();
        initWidget(controlPanel);
        controlPanel.add(toolBar);
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