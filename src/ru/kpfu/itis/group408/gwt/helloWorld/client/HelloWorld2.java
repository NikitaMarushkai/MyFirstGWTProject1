package ru.kpfu.itis.group408.gwt.helloWorld.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public class HelloWorld2 implements EntryPoint {


    private static class OptionalTextBox extends Composite implements ClickHandler {

        private TextBox textBox = new TextBox();
        private CheckBox checkBox = new CheckBox();
        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        /**
         * Style this widget using .optionalTextWidget CSS class.<br/>
         * Style textbox using .optionalTextBox CSS class.<br/>
         * Style checkbox using .optionalCheckBox CSS class.<br/>
         * Constructs an OptionalTextBox with the given caption
         * on the check.
         *
         * @param caption the caption to be displayed with the check box
         */

        public OptionalTextBox(String caption) {
            HorizontalPanel panel = new HorizontalPanel();
            panel.setSpacing(10);
            panel.add(checkBox);
            panel.add(textBox);

            // all composites must call initWidget() in their constructors.
            initWidget(panel);

            setStyleName("optionalTextWidget");

            textBox.setStyleName("optionalCheckBox");

            checkBox.setStyleName("optionalCheckBox");
            textBox.setWidth("200");

            // Set the check box's caption, and check it by default.
            checkBox.setText(caption);
            checkBox.setValue(enabled);
            checkBox.addClickHandler(this);
            enableTextBox(enabled, checkBox.getValue());
        }

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == checkBox) {
                // When the check box is clicked,
                //update the text box's enabled state.
                enableTextBox(enabled, checkBox.getValue());
            }
        }

        private void enableTextBox(boolean enable, boolean isChecked) {
            enabled = (enable && isChecked) || (!enable && !isChecked);
            textBox.setStyleDependentName("disabled", !enable);
            textBox.setEnabled(enable);
        }
    }

    @Override
    public void onModuleLoad() {
        OptionalTextBox otb = new OptionalTextBox("Want to explain the solution?");
        otb.setEnabled(true);
        RootPanel.get().add(otb);
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
        fooMenu.addItem("foo", command);
        fooMenu.addItem("menu", command);

        MenuBar mainMenu = new MenuBar();
        mainMenu.addItem("BAR", menuBar);
        mainMenu.addItem("FOO", fooMenu);
        horizontalPanel.add(mainMenu);

        DatePicker datePicker = new DatePicker();
        final Label text = new Label();

        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                String dateString = DateTimeFormat.getMediumDateFormat().format(date);
                text.setText(dateString);
            }
        });

        datePicker.setValue(new Date(), true);

        RootPanel.get().add(text);
        RootPanel.get().add(datePicker);
        RootPanel.get().add(horizontalPanel);

    }
}
