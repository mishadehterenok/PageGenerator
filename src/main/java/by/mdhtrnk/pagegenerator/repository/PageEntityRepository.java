package by.mdhtrnk.pagegenerator.repository;

import by.mdhtrnk.pagegenerator.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageEntityRepository extends JpaRepository<PageEntity, Long> {

    List<PageEntity> findAllByOrderByPriorityAsc();

    Optional<PageEntity> findBySlug(String slug);
}
