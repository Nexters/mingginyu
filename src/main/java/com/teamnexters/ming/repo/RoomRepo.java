package com.teamnexters.ming.repo;

import com.teamnexters.ming.entity.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Repository
public interface RoomRepo extends JpaRepository<room,Integer> {
    List<room> findTopByOrderByDatetimeDesc();
}
