package com.muratkistan.springmvcregister.repository;

import com.muratkistan.springmvcregister.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
