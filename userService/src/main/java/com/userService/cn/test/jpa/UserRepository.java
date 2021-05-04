/*package com.userService.cn.test.jpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUserName(String userName);
	 
	 @Query(value="select p.* from user p where p.id=?1", nativeQuery=true)
	 User findByAddress(String id);

    // 根据 user_name 查询，
    User findByUserName(String userName);

    // 根据性别，分页查询
    Page<User> findByUserGender(Integer gender, Pageable pageable);

    // 根据用户名和性别查找
    List<User> findByUserNameAndUserGender(String userName, Integer gender);

    // 查找年龄小于 age 的 User
    List<User> findByUserAgeLessThan(Integer age);

    // 查找年龄大于 age 的 User
    List<User> findByUserAgeGreaterThan(Integer age);

    // 查找年龄介于 [minAge，maxAge] 的 User
    List<User> findByUserAgeBetween(Integer minAge, Integer maxAge);

    // 查找名字包含 userName 的 User
    List<User> findByUserNameContaining(String userName);

    // 查找以 userNamePrefix 开头的 User
    List<User> findByUserNameStartingWith(String userNamePrefix);

    // 查找以 userNameSuffix 结尾的 User
    List<User> findByUserNameEndingWith(String userNameSuffix);
}*/