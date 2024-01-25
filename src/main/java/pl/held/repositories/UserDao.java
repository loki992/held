package pl.held.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.held.models.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
User findByLogin(String login);
}
