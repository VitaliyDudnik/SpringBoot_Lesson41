package com.tms.entity;

import com.tms.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @NotEmpty(message = "Username field must not be empty")
    @Pattern(regexp = Constants.REGEX_USERNAME, message = "Username input incorrect, please read Rules")
    private String username;

    @NotEmpty(message = "Password field must not be empty")
    @Pattern(regexp = Constants.REGEX_PASSWORD, message = "Password input incorrect, please read Rules")
    private String password;
}
