package com.lithan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.demo.dto.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer> {

}
