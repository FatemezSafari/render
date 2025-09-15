package com.pro.Aura.repository;

import com.pro.Aura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // این متد رو اضافه کردیم تا بتونیم با ایمیل کاربر رو پیدا کنیم
    Optional<User> findByEmail(String email);

    // این متد رو اضافه کردیم تا بررسی کنیم آیا کاربری با این ایمیل از قبل وجود داره
    // یا نه
    boolean existsByEmail(String email);
}