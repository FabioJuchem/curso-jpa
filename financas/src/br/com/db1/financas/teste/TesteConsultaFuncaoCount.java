package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TesteConsultaFuncaoCount {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 2);

        Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
        query.setParameter("pConta", conta);

        Long quantidade = (Long)query.getSingleResult();
        System.out.println(quantidade);



    }


}
