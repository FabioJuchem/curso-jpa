package br.com.db1.financas.teste;

import br.com.db1.financas.modelo.Categoria;
import br.com.db1.financas.modelo.Conta;
import br.com.db1.financas.modelo.Movimentacao;
import br.com.db1.financas.modelo.TipoMovimentacao;
import br.com.db1.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultados = query.getResultList();

        for(Movimentacao movimentacao: resultados){
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Conta.Id: " + movimentacao.getConta().getId());
        }


    }
}


// EntityManager em = new JPAUtil().getEntityManager();
// em.getTransaction().begin();

//     Categoria categoria = new Categoria();
//   categoria.setId(1);
//
//      String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

//       Query query = em.createQuery(jpql);
//     query.setParameter("pCategoria", categoria);
//
//      List<Movimentacao> resultados = query.getResultList();

//   for (Movimentacao movimentacao : resultados) {
//   System.out.println("Descricao: " + movimentacao.getDescricao());
//    System.out.println("Conta.id: " + movimentacao.getConta().getId());
//    }

//  em.getTransaction().commit();
