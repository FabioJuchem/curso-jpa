package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, 4);
        Conta conta = movimentacao.getConta();

        System.out.println(conta.getTitular());

        System.out.println(conta.getMovimentacoes().size());
    }
}
