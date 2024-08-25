package com.example.bookstoreapi.config;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MetricsConfig {

    private final MeterRegistry meterRegistry;

    public MetricsConfig(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        meterRegistry.gauge("custom.books.total", getBooksCount());
    }
    
    private int getBooksCount() {
        return 42; 
    }
}
