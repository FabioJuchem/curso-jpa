package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itau");
        conta.setNumero("1234");
        conta.setTitular("Leonardo");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));

        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();

    }
}
