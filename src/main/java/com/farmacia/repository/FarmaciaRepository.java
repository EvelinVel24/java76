package main.java.com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farmacia.model.Farmacia;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}
