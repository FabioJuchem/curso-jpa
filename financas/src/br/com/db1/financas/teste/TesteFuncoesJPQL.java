package br.com.db1.financas.teste;

import br.com.db1.financas.dao.MovimentacaoDao;
import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class TesteFuncoesJPQL {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();   //" and m.tipoMovimentacao = :pTipoMovimentacao" + " order by m.valor desc"
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);
        List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);



       for(Double media : medias){
           System.out.println("A media é: " + media);
       }

        em.getTransaction().commit();
        em.close();

    }
}
