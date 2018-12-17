package com.zgg.web.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zgg.web.pojo.ZgUser;

public interface ZgUserRepository extends JpaRepository<ZgUser, Integer> {

	List<ZgUser> findByName(String name);

	// And --- 等价于 SQL 中的 and 关键字
	List<ZgUser> findByNameAndId(String name, int id);

	// Or --- 等价于 SQL 中的 or 关键字
	List<ZgUser> findByNameOrId(String name, int id);

	// Between --- 等价于 SQL 中的 between 关键字
	List<ZgUser> findByIdBetween(int min, int max);

	// LessThan --- 等价于 SQL 中的 "<"
	List<ZgUser> findByIdLessThan(int max);

	// GreaterThan --- 等价于 SQL 中的">"
	List<ZgUser> findByIdGreaterThan(int min);

	// IsNull --- 等价于 SQL 中的 "is null"
	List<ZgUser> findByNameIsNull();

	// IsNotNull --- 等价于 SQL 中的 "is not null"
	List<ZgUser> findByNameIsNotNull();

	// NotNull --- 与 IsNotNull 等价；
	List<ZgUser> findByNameNotNull();

	// OrderBy --- 等价于 SQL 中的 "order by"
	List<ZgUser> findByNameNotNullOrderByIdAsc();

	// OrderBy --- 等价于 SQL 中的 "order by"
	List<ZgUser> findByNameNotNullOrderByIdDesc();

	// Not --- 等价于 SQL 中的 "！ ="
	List<ZgUser> findByNameNot(String name);

	// In --- 等价于 SQL 中的 "in"
	List<ZgUser> findByNameIn(List<String> name);

	// NotIn --- 等价于 SQL 中的 "not in"
	List<ZgUser> findByNameNotIn(List<String> name);

	@Query("from zg_user u where u.name=:name")
	ZgUser findZgUser(@Param("name") String name);

	// Like --- 等价于 SQL 中的 "like"
	@Query("from zg_user u where u.name like %:name%")
	List<ZgUser> findByNameLike(@Param("name") String name);

	// NotLike --- 等价于 SQL 中的 "not like"
	@Query("from zg_user u where u.name not like %:name%")
	List<ZgUser> findByNameNotLike(@Param("name") String name);
	
	Page<ZgUser> findAll(Pageable pageable);
	
	@Query(value = "SELECT id, name FROM zg_user LIMIT :s,:e ",nativeQuery=true)
	List<ZgUser> findBySomething(@Param("s") int start, @Param("e") int end);
}
