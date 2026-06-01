package br.pucrs.nomeusuario.exemplo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "hello")
public class HelloWorldView extends VerticalLayout {
   public HelloWorldView() {
       Button sayHello = new Button("Say hello");
       sayHello.addClickListener(e -> {
             Notification.show("Hello world!");
       });
       add(sayHello);
   }
}
