package com.caresyntax.scheduling;

import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import com.caresyntax.scheduling.domain.entity.RoomEntity;
import com.caresyntax.scheduling.repository.DoctorRepository;
import com.caresyntax.scheduling.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by Parviz on 10.05.2018.
 */
@SpringBootApplication
public class ApplicationBootstrap {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationBootstrap.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public CommandLineRunner loadData(DoctorRepository doctorRepository, RoomRepository roomRepository) {
        return args -> {
            // save a couple of doctors
            doctorRepository.save(new DoctorEntity("Dr. Finlay "));
            doctorRepository.save(new DoctorEntity("Dr. Mark Hall"));
            doctorRepository.save(new DoctorEntity("Dr. Peter Leavitt"));
            doctorRepository.save(new DoctorEntity("Dr. Jeremy Stone"));
            // fetch all doctors
            LOGGER.info("available doctors:");
            LOGGER.info("-------------------------------");
            for (DoctorEntity doctor : doctorRepository.findAll()) {
                LOGGER.info(doctor.getName());
            }
            //save a couple of rooms
            roomRepository.save(new RoomEntity("Room 1"));
            roomRepository.save(new RoomEntity("Room 2"));
            roomRepository.save(new RoomEntity("Room 3"));
            roomRepository.save(new RoomEntity("Room 4"));
            // fetch all rooms
            LOGGER.info("available Rooms:");
            LOGGER.info("-------------------------------");
            for (RoomEntity room : roomRepository.findAll()) {
                LOGGER.info(room.getName());
            }

        };
    }


}
