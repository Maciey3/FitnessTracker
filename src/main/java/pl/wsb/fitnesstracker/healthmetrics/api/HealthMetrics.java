package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.persistence.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
public class HealthMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @Column
    private LocalDate date;
    @Column
    private Float weight;
    @Column
    private Long height;
    @Column(nullable = false)
    private Long heartRate;
}
