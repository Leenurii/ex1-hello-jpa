package hellojpa;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    static public void  main(String []args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code 작성 디비를 불러온다던지 하는...
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            List<Member> result = em.createQuery( "select m from Member as m", Member.class).getResultList();

          for(Member member : result){
                System.out.println("member.name = " +member.getName() );
            }/*
            Member findMember = em.find(Member.class,3L);
            findMember.setName("HelloJPA");
*/

            tx.commit();

        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();









       /* EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(20L);
        member.setName("HelloA");
        member.setAge(10);

        em.persist(member);

        Member member2 = new Member();
        member2.setId(21L);
        member2.setName("HelloB");
        member2.setAge(21);

        em.persist(member2);


        tx.commit();
        em.close();
        emf.close();
*/
    }

}
