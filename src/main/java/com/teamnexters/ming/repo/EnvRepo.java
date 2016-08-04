package com.teamnexters.ming.repo;

import com.teamnexters.ming.entity.env;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Repository
public interface EnvRepo extends JpaRepository<env,Integer> {
    env findByEnvkey(String key);
}
