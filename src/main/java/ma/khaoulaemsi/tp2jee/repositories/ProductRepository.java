package ma.khaoulaemsi.tp2jee.repositories;

import ma.khaoulaemsi.tp2jee.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product,Long> {
}
