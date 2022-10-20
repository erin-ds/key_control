package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.KeyType;

import java.util.Optional;

@Repository
public interface KeyTypeRepository extends CommonRepository<KeyType>{

    Optional<KeyType> findByName(String name);
}
