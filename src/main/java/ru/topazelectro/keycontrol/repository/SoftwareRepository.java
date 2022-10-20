package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.Software;

import java.util.Optional;

@Repository
public interface SoftwareRepository extends CommonRepository<Software> {

    Optional<Software> findByName(String name);
}
