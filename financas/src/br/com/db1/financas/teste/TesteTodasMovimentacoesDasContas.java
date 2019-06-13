package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteTodasMovimentacoesDasContas {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        String jpql = "select c from Movimentacao c where id = 10";
        Query query = em.createQuery(jpql);


        List<Movimentacao> resultado = query.getResultList();

        for (Movimentacao movimentacao: resultado){
            System.out.println(movimentacao.getDescricao());
        }



    }
}
