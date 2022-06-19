package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.FinancialDB.accountant.Entry;
import com.mydomain.project_server.models.FinancialDB.accountant.Factor;
import com.mydomain.project_server.repositories.FinancialDB.EntryRepository;
import com.mydomain.project_server.repositories.FinancialDB.FactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    final
    EntryRepository e_repo;

    final
    FactorRepository f_repo;

    public FinancialService(EntryRepository e_repo, FactorRepository f_repo) {
        this.e_repo = e_repo;
        this.f_repo = f_repo;
    }

    public Entry getEntryById(String entry_id) {

        return e_repo.findById(entry_id).get();
    }

    public void deleteCardById(String entry_id) {
    }

    public Entry insert(Entry entry1) {
        return e_repo.save(entry1);
    }

    public List<Factor> getAllFactors() {
        return f_repo.findAll();
    }

    public Factor getFactorById(String factor_id) {
        return f_repo.findById(factor_id).get();
    }

    public boolean getFactorStatus(String factor_id) {
        return e_repo.findById(factor_id).get().isApproved();
    }

    public void deleteFactor(Factor factor) {

        f_repo.delete(factor);
    }

}
