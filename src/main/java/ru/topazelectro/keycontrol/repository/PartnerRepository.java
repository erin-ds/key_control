package ru.topazelectro.keycontrol.repository;

import org.springframework.stereotype.Repository;
import ru.topazelectro.keycontrol.entity.Partner;

import java.util.Optional;

@Repository
public interface PartnerRepository extends CommonRepository<Partner>{

    Optional<Partner> findByName(String name);
}
