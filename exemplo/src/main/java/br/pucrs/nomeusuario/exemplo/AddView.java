package br.pucrs.nomeusuario.exemplo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;


@Route("adicionar")
public class AddView extends VerticalLayout {
   public AddView() {
      TextField nome =  new TextField("Nome");
      TextField email = new TextField("Email");
      
      Button cancelar = new Button("Cancelar");
      Button salvar =   new Button("Salvar");

      HorizontalLayout botoesLayout = 
          new HorizontalLayout(cancelar, salvar);          
      VerticalLayout layoutPrincipal = 
          new VerticalLayout(nome, email,
                             botoesLayout);
            
      add(layoutPrincipal);
  }
}