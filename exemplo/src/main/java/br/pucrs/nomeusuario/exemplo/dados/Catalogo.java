package br.pucrs.nomeusuario.exemplo.dados;

import java.util.*;

public class Catalogo {
    private List<Conta> contas;

    public Catalogo() {
        contas = new ArrayList<Conta>();
    }

    public boolean addConta(Conta c) {
        return contas.add(c);
    }

    public Conta getContaByNumero(int numero) {
        for(Conta c : contas) {
            if(c.getNumero() == numero)
                return c;
        }
        return null;
    }
}
