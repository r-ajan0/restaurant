package com.example.restaurant.repository;

import com.example.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,  value = """
                    select 
                        count(id)=0
                    from users
                    where id<>?2 and phone_number=?1
            """)
    boolean validateNumber(String number, Long id);
}
