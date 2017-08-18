package com.ajay.main;

import com.ajay.service.CabManagementService;

public class LaunchApplication {
	

	public static void main(String[] args) {
		CabManagementService cabManagementService = new CabManagementService();
		try {
			cabManagementService.executeRequest();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
