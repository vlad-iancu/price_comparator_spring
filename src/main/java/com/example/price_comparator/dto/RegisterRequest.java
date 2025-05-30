package com.example.price_comparator.dto;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@GroupSequence({
    RegisterRequest.class, 
    RegisterRequest.Empty.class, 
    RegisterRequest.Invalid.class, 
    RegisterRequest.MinLength.class
})
public class RegisterRequest {
    public interface Empty {
    }
    
    public interface Invalid {
    }

    public interface MinLength {
    }
    @Pattern(
            regexp = "^[a-zA-Z0-9._-]{3,}$",
            message = "Username must be at least 3 characters long and can only contain letters, numbers, dots, underscores, and hyphens",
            groups = Invalid.class)
    @NotBlank(
        message = "Username is required",
        groups = Empty.class)
    private String username;

    @Size(
        min = 8, 
        message = "Password must be at least 8 characters long",
        groups = MinLength.class)
    @NotBlank(
        message = "Password is required",
        groups = Empty.class)
        
    private String password;

    // Getters and setters (or use Lombok)
}
