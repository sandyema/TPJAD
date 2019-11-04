package hello.Repository;
import hello.Domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface contactRepository extends JpaRepository<Contact,Integer> {
    List<Contact> findAll();

    @Override
    Contact findOne(Integer integer);
}
