package com.neurogine.demo.service;

import com.neurogine.demo.model.Merchant;

public interface MerchantService {
	
	public Merchant createMerchant(String name, long merchantId);
	
	public void deleteMerchant(long merchantId);

}
