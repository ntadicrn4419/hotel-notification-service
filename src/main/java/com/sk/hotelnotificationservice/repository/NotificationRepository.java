package com.sk.hotelnotificationservice.repository;

import com.sk.hotelnotificationservice.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Override
    Optional<Notification> findById(Long id);
}
