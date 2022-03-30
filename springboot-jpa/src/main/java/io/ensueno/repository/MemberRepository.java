package io.ensueno.repository;

import io.ensueno.Entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 저장을 하고 나면 가급적이면 사이드 이팩트를 발생시키는 커맨드 성이기 때문에 리턴 값을 만들지 않고 Id 정도만 조회하는 방식으로 설계
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
