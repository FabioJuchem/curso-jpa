package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();   //" and m.tipoMovimentacao = :pTipoMovimentacao" + " order by m.valor desc"
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipoMovimentacao order by m.valor desc";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);

        List<Movimentacao> resultados = query.getResultList();

        for (Movimentacao movimentacao : resultados) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id: " + movimentacao.getConta().getId());
        }

        em.getTransaction().commit();

    }
}
