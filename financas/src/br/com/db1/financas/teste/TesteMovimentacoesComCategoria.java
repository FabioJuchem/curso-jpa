package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Categoria;
import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteMovimentacoesComCategoria {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negocios");

        Conta conta = new Conta();
        conta.setId(2);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); //hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(Calendar.getInstance()); // hoje
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();



        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(movimentacao1);
        em.persist(movimentacao2);

        //Movimentacao movimentacao = em.find(Movimentacao.class,7);
       // movimentacao.setValor(new BigDecimal("300.0"));

        em.getTransaction().commit();
        em.close();

    }
}

