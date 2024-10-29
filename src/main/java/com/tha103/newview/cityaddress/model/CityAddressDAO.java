package com.tha103.newview.cityaddress.model;

import java.util.List;

import com.tha103.newview.act.model.ActVO;

public interface CityAddressDAO {

	void insert(CityAddress act);

	void update(CityAddress act);

	void delete(Integer ActID);

	CityAddress findByPrimaryKey(Integer ActID);

	List<CityAddress> getAll();
}
