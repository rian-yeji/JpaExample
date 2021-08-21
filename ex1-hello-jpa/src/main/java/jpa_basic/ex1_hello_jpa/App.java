package jpa_basic.ex1_hello_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        // 한 프로그램에서 한 DB당 한번만 만들어야 함.
        // 스레드간에 공유해서 사용
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        
        // 실제 쿼리 수행할 부분에서 만들고 close하면서 써야 함
        // 스레드간에 공유하면 절대 안됨.
        EntityManager em = emf.createEntityManager();
        
        // JPA는 데이터 변경이 있을때 반드시 Transaction안에서 수행해야 함.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {
        	Member member = new Member();
            member.setUsername("helloJPA");
            em.persist(member);
/*        	
        	// 1. 등록
        	Member member = new Member();
            member.setId(1L);
            member.setName("helloJPA");
            em.persist(member);

        	// 2. 조회
        	Member findMember = em.find(Member.class, 1L);
        	System.out.println("findMember : "+findMember.toString());
        	
        	// 3.삭제
        	Member deleteMember = em.find(Member.class, 1L);
        	em.remove(deleteMember);
        	
        	// 4. 수정
        	Member findMember = em.find(Member.class, 1L);
        	findMember.setName("test");
        	
        	// JPQL : 객체 지향 쿼리 언어 제공 (SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원)
        	// JPQL은 엔티티 객체를 대상으로 쿼리, SQL은 DB테이블을 대상으로 쿼리
        	// => DB가 바뀌더라도 쿼리를 변경하지 않아도 됨. (객체지향 SQL)
        	List<Member> memberList = em.createQuery("select * from member",Member.class)
        			.setFirstResult(1) // 1번부터
        			.setMaxResults(10) // 10번 까지 가져옴
        			
        			.getResultList();
        	
        	System.out.println("memberList : "+memberList.toString());
        	*/
            
            tx.commit();
            
            
        }catch(Exception e) {
            tx.rollback();
        }finally {
        	// EntityManager는 DB Connection을 물고 있기때문에 반드시 반환해야 함.
            em.close();
        }
        
        //close
        emf.close();
    }
}
