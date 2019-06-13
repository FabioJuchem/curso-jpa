package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

public class TesteConsultaFuncaoMax {
    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        String jpql = "select min(m.valor) from Movimentacao m where m.conta = :pConta";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        BigDecimal min = (BigDecimal) query.getSingleResult();

        System.out.println("O valor minimo é: " + min);

    }
}
