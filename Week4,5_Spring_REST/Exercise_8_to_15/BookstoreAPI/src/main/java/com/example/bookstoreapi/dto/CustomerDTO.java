package com.example.bookstoreapi.dto;
import jakarta.validation.constraints.*;

public class CustomerDTO {
    private Long id;
    
    @NotNull(message = "Name is required")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;
    
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
