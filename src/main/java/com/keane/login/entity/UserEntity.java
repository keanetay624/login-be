package com.keane.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_TBL")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private int isManager;

    public UserEntity(String userName, String password, String fullName, int isManager) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.isManager = isManager;
    }
}
