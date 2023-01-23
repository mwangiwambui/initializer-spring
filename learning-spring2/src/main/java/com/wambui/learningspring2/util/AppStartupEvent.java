package com.wambui.learningspring2.util;

import com.wambui.learningspring2.data.Room;
import com.wambui.learningspring2.data.RoomRespository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRespository roomRespository;

    public AppStartupEvent(RoomRespository roomRespository) {
        this.roomRespository = roomRespository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRespository.findAll();
        rooms.forEach(System.out::println);
    }
}
