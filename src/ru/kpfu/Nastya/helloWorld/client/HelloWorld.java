package ru.kpfu.Nastya.helloWorld.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.List;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public class HelloWorld implements EntryPoint {


    private static final List<String> CONTACTS = java.util.Arrays.asList("First", "Second", "Third",
            "Nastya", "Natalia", "Nikita", "Someone");

    @Override
    public void onModuleLoad() {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setSpacing(10);
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.HorizontalAlignmentConstant.startOf(HasDirection.Direction.RTL));
        Command command = new Command() {
            @Override
            public void execute() {
                Window.alert("You've selected a menu item");
            }
        };

        MenuBar menuBar = new MenuBar(true);
        menuBar.addItem("My", command);
        menuBar.addItem("Menu", command);

        MenuBar fooMenu = new MenuBar(true);
        fooMenu.addItem("The", command);
        fooMenu.addItem("first", command);
        fooMenu.addItem("menu", command);

        MenuBar thirdMenu = new MenuBar(true);
        thirdMenu.addItem("The", command);
        thirdMenu.addItem("Third", command);
        thirdMenu.addItem("Menu", command);

        MenuBar mainMenu = new MenuBar();
        mainMenu.addItem("First", menuBar);
        mainMenu.addItem("Second", fooMenu);
        mainMenu.addItem("Third", thirdMenu);
        horizontalPanel.add(mainMenu);

        //Create cell to render each value
        TextCell textCell = new TextCell();

        //Create CellList that uses the cell
        CellList<String> cellList = new CellList<>(textCell);
        cellList.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        //Selection model to handle user selection
        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<>();
        cellList.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                String selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected " + selected);
                }
            }
        });


        // Set the total row count. This isn't strictly necessary, but it affects
        // paging calculations, so its good habit to keep the row count up to date.
        cellList.setRowCount(CONTACTS.size(), true);
        cellList.setRowData(0, CONTACTS);

        //Tree
        TreeItem root = new TreeItem();
        root.setText("root");
        root.addTextItem("item1");
        root.addTextItem("item2");
        root.addTextItem("item3");
        root.addTextItem("item4");

        TreeItem item = new TreeItem(new TextBox());
        root.addItem(item);

        Tree t = new Tree();
        t.addItem(root);

        RootPanel.get().add(t);

        RootPanel.get().add(cellList);
        RootPanel.get().add(horizontalPanel);

    }
}
