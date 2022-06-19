package com.mydomain.project_server.repositories.FinancialDB;

import com.mydomain.project_server.models.FinancialDB.accountant.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, String> {



}
