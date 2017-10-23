package jpa;

import com.hy.example.entity.Person;
import com.hy.example.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
    ApplicationContext ctx;
    PersonRepository personRepository;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        personRepository = ctx.getBean(PersonRepository.class);
    }

    @Test
    public void jpaTest() {
        Person person = new Person();
        person.setId(100);
        person.setName("黄宇");
        person.setPassword("aaa111");
        personRepository.save(person);
        Assert.assertTrue(personRepository.findAll().size() >= 1);
        System.out.println(personRepository.findByName("黄宇"));
    }
}
