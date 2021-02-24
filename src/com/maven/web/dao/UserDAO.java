package com.maven.web.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	List<Map<String,String>> getUserList(Map<String,String> pUser);
	
	
}
