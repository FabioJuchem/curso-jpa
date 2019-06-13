package br.com.db1.financas.dao;

import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipoMovimentacao group by day(m.data), month(m.data), year(m.data)";

        TypedQuery query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);

        return query.getResultList();

    }
}
