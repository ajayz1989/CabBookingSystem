package com.ajay.dao;

import java.util.ArrayList;
import java.util.List;

import com.ajay.entity.Area;
import com.ajay.entity.Cab;
import com.ajay.util.Utils;

/**
 * DAO for all CRUD operations related to {@link Cab} entity .
 */
public class CabDAO {
	
	private List<Cab> cabDetailList = new ArrayList<>();

	public List<Cab> getAllCabs() {
		cabDetailList.add(new Cab("DL01HB001",new Area(100020, 20),Utils.getFutureTime(9)));
		cabDetailList.add(new Cab("DL01HB002",new Area(100040, 40),Utils.getFutureTime(9)));
		cabDetailList.add(new Cab("DL01HB003",new Area(100060, 60),Utils.getFutureTime(9)));
		cabDetailList.add(new Cab("DL01HB004",new Area(100080, 80),Utils.getFutureTime(9)));
		
		return cabDetailList;
	}

}
