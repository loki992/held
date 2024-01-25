package pl.held.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.held.models.Game;

@Repository
@Transactional
public interface GameDao extends JpaRepository<Game, Long> {
}
