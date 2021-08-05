package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repositotory = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
    repositotory.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repositotory.save(member);

        Member result = repositotory.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositotory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositotory.save(member2);

        Member result = repositotory.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositotory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositotory.save(member2);

        List<Member> result = repositotory.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
