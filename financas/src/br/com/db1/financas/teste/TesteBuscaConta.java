package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class,1);

        conta.setTitular("Joao");
        conta.setAgencia("456");

        System.out.println(conta.getTitular());

        em.getTransaction().commit();
        em.close();

        EntityManager em2 = new JPAUtil().getEntityManager();
        em2.getTransaction().begin();

        conta.setTitular("Leonardo");
        em2.merge(conta);

        em2.getTransaction().commit();
        em2.close();


    }

}
