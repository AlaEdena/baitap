package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String role_id;
    @Column(nullable = false)
    private String role_name;
    @OneToMany(mappedBy = "role")
    private List<User> users;


    //  boolean role_is_deleted;

}
