package ru.topazelectro.keycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.topazelectro.keycontrol.entity.CommonEntity;

@NoRepositoryBean
public interface CommonRepository<KEY_CONTROL extends CommonEntity> extends JpaRepository<KEY_CONTROL, Long> {
}
