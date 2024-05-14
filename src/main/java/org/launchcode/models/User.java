package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 15, message = "Username needs to have at least 5 characters and no less than 15 characters")
    private String username;

    @Email(message = "Email needs to be in the correct format")
    private String email;

    @Size(min = 6, message = "Password needs to have at least 6 characters")
    private String password;

    @Size(min = 6, message = "Password needs to have at least 6 characters")
    private String verify;

    public User() {

    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return this.verify;
    }



    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }
    private void checkPassword() {
        if (password != null && verify != null && !password.equals(verify)) {
            setVerify(null);
        }
    }
}

