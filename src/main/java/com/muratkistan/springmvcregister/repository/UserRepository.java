package com.muratkistan.springmvcregister.repository;

import com.muratkistan.springmvcregister.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
