package hello.Repository;

import hello.Domain.Contact;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface IRepoContact extends IRepository<Integer, Contact> {
}
