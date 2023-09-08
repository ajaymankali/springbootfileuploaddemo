package cgg.springboot.servervalidations.springbootservervalidationsdemo.entities;

import cgg.springboot.servervalidations.springbootservervalidationsdemo.validations.ImageNameValid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class LoginData {
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 12, message = "Username must be between 3 to 12 characters")
    private String username;

    @Pattern(regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$", message = "Invalid email!")
    private String email;

    @AssertTrue(message = "Must agree to terms and conditions")
    private boolean agreed;

    @ImageNameValid
    private String imageName;

    public LoginData() {
      
    }

    @Override
    public String toString() {
        return "LoginData [username=" + username + ", email=" + email + ", agreed=" + agreed + "]";
    }

    public LoginData( @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 12, message = "Username must be between 3 to 12 characters") String username,  @Pattern(regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$", message = "Invalid email!") String email, @AssertTrue(message = "Must agree to terms and conditions")boolean agreed) {
        this.username = username;
        this.email = email;
        this.agreed = agreed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }
    
}

