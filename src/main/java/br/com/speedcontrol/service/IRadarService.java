package br.com.speedcontrol.service;

import java.sql.Timestamp;
import java.util.List;

public interface IRadarService {
	
	public void registerSpeed(Timestamp time, float speed, List<String> tags);

}
