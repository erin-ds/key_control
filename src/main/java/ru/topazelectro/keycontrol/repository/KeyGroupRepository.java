package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.KeyGroup;

import java.util.Optional;

@Repository
public interface KeyGroupRepository extends CommonRepository<KeyGroup> {

    Optional<KeyGroup> findByNumber(Long number);
}
