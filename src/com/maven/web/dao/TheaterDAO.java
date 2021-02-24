package com.maven.web.dao;

import java.util.List;
import java.util.Map;

public interface TheaterDAO {

	List<Map<String,String>> getTheaterList(Map<String,String> pti);
	
}
