package br.com.alura.dojoplaces.repository;

import br.com.alura.dojoplaces.place.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    boolean existsByCode(String code);

    boolean existsByCodeAndIdNot(String code, Long idToExclude);

    Optional<Place> findById(Long id);
}
