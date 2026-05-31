package br.pucrs.nomeusuario.exemplo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("") // Serves the view at the root URL (http://localhost:8080/)
public class MainView extends VerticalLayout {

    // Spring dependencies are automatically injected
    public MainView() {
        TextField nameField = new TextField("Enter your name");
        Button greetButton = new Button("Say Hello");

        // Event handling is handled entirely on the server side
        greetButton.addClickListener(event -> {
            String message = nameField.getValue();
            Notification.show(message);
        });

        // Add components to this VerticalLayout container
        add(nameField, greetButton);
    }
}
