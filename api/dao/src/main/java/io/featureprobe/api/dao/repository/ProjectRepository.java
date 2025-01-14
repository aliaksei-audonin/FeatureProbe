package io.featureprobe.api.dao.repository;

import io.featureprobe.api.dao.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByKey(String key);

    List<Project> findByKeyIn(Set<String> keys);

    boolean existsByKey(String key);

    boolean existsByName(String name);

    List<Project> findAllByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String keywordName,
                                                                                 String keywordDesc);

    List<Project> findAllByOrderByCreatedTimeDesc();

}
