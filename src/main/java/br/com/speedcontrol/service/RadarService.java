package br.com.speedcontrol.service;

import java.sql.Timestamp;
import java.util.List;

import br.com.speedcontrol.dao.ISpeedDao;
import br.com.speedcontrol.dao.SpeedDao;

public class RadarService implements IRadarService {
	
	private ISpeedDao speedDao;
	
	public RadarService() {
		speedDao = new SpeedDao();
	}

	public void registerSpeed(Timestamp time, float speed, List<String> tags) {
		speedDao.registerSpeed(time, speed, tags);
	}

}
