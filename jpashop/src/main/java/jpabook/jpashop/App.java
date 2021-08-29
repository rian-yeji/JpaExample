package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class App 
{
    public static void main( String[] args )
    {
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
        	Book book = new Book();
        	book.setName("JPA");
        	book.setAuthor("A");
        	
        	em.persist(book);

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
