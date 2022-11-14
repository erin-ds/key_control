package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.Key;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyRepository extends CommonRepository<Key> {

    List<Key> findByNumberHex(String numberHex);
}