package com.develhope.spring.ShowroomProfit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowroomProfitRepository extends JpaRepository<ShowroomProfit, Long> {
}
