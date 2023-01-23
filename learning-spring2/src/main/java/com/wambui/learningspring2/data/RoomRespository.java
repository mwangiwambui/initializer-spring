package com.wambui.learningspring2.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRespository extends CrudRepository<Room, Long> {
}
