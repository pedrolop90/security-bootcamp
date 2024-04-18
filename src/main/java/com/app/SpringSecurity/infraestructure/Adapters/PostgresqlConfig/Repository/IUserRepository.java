package com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Repository;


import com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);




}
