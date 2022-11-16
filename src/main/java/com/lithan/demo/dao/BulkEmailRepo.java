package com.lithan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.demo.dto.BulkEmail;

public interface BulkEmailRepo extends JpaRepository<BulkEmail,Integer> {

}
