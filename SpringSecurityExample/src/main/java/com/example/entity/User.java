package com.example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

/* Методы UserDetails захордкожины
   метод getAuthorities() возвращает список ролей пользователя
 */

@Entity
@Table(name = "t_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Не меньше 5 знаков")
    private String username;

    @Size(min = 2, message = "Не меньше 5 знаков")
    private String password;

    //Поле, находящееся под аннотацией Transient, не имеет отображения в БД.
    @Transient
    private String passwordConfirm;

    /*
    Список ролей связан с пользователем отношением многие ко многим
    (один пользователь может иметь несколько ролей с одной стороны и
    у одной роли может быть несколько пользователей с другой)
    FetchType.EAGER – «жадная» загрузка, т.е. список ролей
    загружается вместе с пользователем сразу (не ждет пока к нему обратятся).
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
