package com.neurogine.demo.service;

import java.util.Optional;

import com.neurogine.demo.model.Merchant;
import com.neurogine.demo.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.neurogine.demo.exphandler.TaskException;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
//	Question 2
	@Autowired
MerchantRepository merchantRepository;

	@Override
	public Merchant createMerchant(String name, long merchantId) {
		Merchant merchant = new Merchant();
		merchant.setId(merchantId);
		merchant.setName(name);
		return merchantRepository.save(merchant);
	}

	@Override
	public void deleteMerchant(long merchantId) throws TaskException {
		Optional<Merchant> merchant = merchantRepository.findById(merchantId);
		if(!merchant.isPresent()) {
			throw new TaskException("Merchant not found : " + merchantId, HttpStatus.NOT_FOUND);
		}
		merchantRepository.delete(merchant.get());

	}

}
