package com.alfacentauri.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfacentauri.core.dao.PaymentDAO;

@Service // Es un servicio de spring
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired // Para que haga la injeccion de dependencias
	private PaymentDAO dao;

	public PaymentDAO getDao() {
		return dao;
	}

	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
}
