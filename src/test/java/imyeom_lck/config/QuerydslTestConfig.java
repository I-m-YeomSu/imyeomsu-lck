package imyeom_lck.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import imyeom_lck.member.persistence.querydsl.QueryMemberRepository;
import imyeom_lck.member.persistence.querydsl.QueryMemberRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class QuerydslTestConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(this.entityManager);

    }



}