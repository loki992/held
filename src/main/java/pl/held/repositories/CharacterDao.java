package pl.held.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.held.models.Character;

@Repository
@Transactional
public interface CharacterDao extends JpaRepository<Character, Long> {
}
