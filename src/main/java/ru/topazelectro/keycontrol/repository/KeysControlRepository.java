package ru.topazelectro.keycontrol.repository;

import liquibase.pro.packaged.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeysControlRepository extends JpaRepository<T, Long> {
}
