package com.teamnexters.ming.repo;

import com.teamnexters.ming.entity.plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Repository
public interface PlantRepo extends JpaRepository<plant,Integer> {
    List<plant> findTopByOrderByDatetimeDesc();
}
