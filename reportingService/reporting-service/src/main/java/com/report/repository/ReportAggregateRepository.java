package com.report.repository;

import com.report.Entity.ReportAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportAggregateRepository extends JpaRepository<ReportAggregate, Long> {

}
