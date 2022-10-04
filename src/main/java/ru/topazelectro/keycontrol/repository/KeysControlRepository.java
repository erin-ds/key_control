package ru.topazelectro.keycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.CommonEntity;

@Repository
public interface KeysControlRepository extends JpaRepository<CommonEntity, Long> {
}
