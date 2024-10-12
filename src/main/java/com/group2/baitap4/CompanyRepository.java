package com.group2.baitap4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends JpaRepository<CompanyModel, Integer>
{
}
