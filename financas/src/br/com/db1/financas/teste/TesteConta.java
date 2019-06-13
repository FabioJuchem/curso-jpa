package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1);
        conta.setTitular("Danilo");
        conta.setBanco("Banco do Brasil");
        conta.setAgencia("123");
        conta.setNumero("456");


        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        conta = em.find(Conta.class,1);
        em.remove(conta);

        conta.setBanco("Bradesco");

        em.getTransaction().commit();
        em.close();


    }
}
