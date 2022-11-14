package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.Key;

import java.util.Optional;

@Repository
public interface KeyRepository extends CommonRepository<Key> {

    Optional<Key> findByNumberHex(String numberHex);
}