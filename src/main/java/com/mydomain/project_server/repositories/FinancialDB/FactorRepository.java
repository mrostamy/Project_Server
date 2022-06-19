package com.mydomain.project_server.repositories.FinancialDB;

import com.mydomain.project_server.models.FinancialDB.accountant.Entry;
import com.mydomain.project_server.models.FinancialDB.accountant.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor, String> {



}
