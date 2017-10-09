package com.predic8.workshop.repository;

import com.predic8.workshop.domain.Key;
import com.predic8.workshop.domain.Trend;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TrendRepository extends CrudRepository<Trend, Key> {
	@Query("select * from trend.trend where uuid = ?0 and timestamp <= toTimeStamp(now())")
	List<Trend> findTrends(String uuid);
}