package com.neurogine.demo.repository;

import com.neurogine.demo.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
