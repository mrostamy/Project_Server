package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.user.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, String> {
}
