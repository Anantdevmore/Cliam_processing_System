package com.audit.repository;

import com.audit.Entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByUserId(Long userId);
    List<AuditLog> findByServiceName(String serviceName);

    @Query("SELECT a FROM AuditLog a WHERE a.timestamp BETWEEN :start AND :end")
    List<AuditLog> findLogsBetweenDates(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
