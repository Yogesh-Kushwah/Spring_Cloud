package com.lcwd.user.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name="ID")
    private  String userId;

    @Column(name="Name",length = 10)
    private String name;

    @Column(name="Email")
    private  String email;

    @Column(name="About")
    private String about;

    @Transient // this is used b/c we don't want to store in Db
    private List<Rating> ratings= new ArrayList<>();
}
