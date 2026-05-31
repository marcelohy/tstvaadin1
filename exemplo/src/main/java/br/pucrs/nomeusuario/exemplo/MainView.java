package br.pucrs.nomeusuario.exemplo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import br.pucrs.nomeusuario.exemplo.dados.Catalogo;
import br.pucrs.nomeusuario.exemplo.dados.Conta;

@Route("") 
public class MainView extends VerticalLayout {
    private Catalogo catalogo;

    // Spring dependencies are automatically injected
    public MainView() {
        inicializa();

        TextField campoNumero = new TextField("Entre o numero da conta");
        Button botaoPesq = new Button("Pesquisa");
        Button botaoLimpar = new Button("Limpar");
        TextField campoMensagem = new TextField("Mensagem");

        // Add components to this VerticalLayout container
        add(campoNumero, botaoPesq, botaoLimpar,campoMensagem);
        // Event handling is handled entirely on the server side

        botaoPesq.addClickListener(event -> {
            String message = campoNumero.getValue();
            int numero = Integer.parseInt(message);
            Conta c = catalogo.getContaByNumero(numero);
            if(c != null) 
                campoMensagem.setValue("Saldo: "+c.getSaldo());
            else
                Notification.show("Conta nao encontrada");
        });

        botaoLimpar.addClickListener(event -> {
            campoNumero.setValue("");
            campoMensagem.setValue("");
        });
    }

    private void inicializa() {
        catalogo = new Catalogo();
        catalogo.addConta(new Conta(11,111.11));
        catalogo.addConta(new Conta(22,222.22));
        catalogo.addConta(new Conta(33,333.33));
    }
}
