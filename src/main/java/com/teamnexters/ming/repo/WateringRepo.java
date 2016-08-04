package com.teamnexters.ming.repo;

import com.teamnexters.ming.entity.watering;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by limjuhyun on 7/31/16.
 */
public interface WateringRepo  extends JpaRepository<watering,Integer> {
}
