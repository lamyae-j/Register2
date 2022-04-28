package com.example.Demo.registration.token;




import com.example.Demo.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )

    private long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    @Column(nullable = false)
    private LocalDateTime ConfirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable=false,
            name="app_user_id"
    )

    private AppUser appuser;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,

                             AppUser appuser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;

        this.appuser = appuser;
    }*/


    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class ConfirmationToken {

        @SequenceGenerator(
                name = "confirmation_token_sequence",
                sequenceName = "confirmation_token_sequence",
                allocationSize = 1
        )
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "confirmation_token_sequence"
        )
        private Long id;

        @Column(nullable = false)
        private String token;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @Column(nullable = false)
        private LocalDateTime expiresAt;

        private LocalDateTime confirmedAt;

        @ManyToOne
        @JoinColumn(
                nullable = false,
                name = "app_user_id"
        )
        private AppUser appUser;

        public ConfirmationToken(String token,
                                 LocalDateTime createdAt,
                                 LocalDateTime expiresAt,
                                 AppUser appUser) {
            this.token = token;
            this.createdAt = createdAt;
            this.expiresAt = expiresAt;
            this.appUser = appUser;
        }


}
