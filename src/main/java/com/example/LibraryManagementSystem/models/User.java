package com.example.LibraryManagementSystem.models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Boolean getActive(){return active;}
    public void setActive(Boolean active){this.active = active;}
    public String getUserName(){return userName;}
    public void setUserName(String userName){this.userName = userName;}
    public String getPassword(){return password;}
    public Set<Role> getRoles(){return roles;}
    public void setPassword(String password){this.password = password;}
    public void setRoles(Set<Role> roles){this.roles = roles;}
}