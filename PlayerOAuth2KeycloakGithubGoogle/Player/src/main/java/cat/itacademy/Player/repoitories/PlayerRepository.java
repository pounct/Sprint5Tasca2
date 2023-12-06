package cat.itacademy.Player.repoitories;

import cat.itacademy.Player.entities.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long>{

	@Query("SELECT p FROM Player p WHERE p.username LIKE :x")
	public Page<Player> search(@Param("x") String keyword, Pageable pageable);
}
