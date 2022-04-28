package com.example.Demo.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenRepository
        extends JpaRepository<ConfirmationToken,Long> {

    Optional<ConfirmationToken> findByToken(String Token);

    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
