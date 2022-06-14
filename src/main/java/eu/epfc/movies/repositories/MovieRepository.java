package eu.epfc.movies.repositories;

import eu.epfc.movies.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("select m from Movie m where m.name like :x")
    Page<Movie> search(@Param("x") String kw, Pageable pageable);
}
