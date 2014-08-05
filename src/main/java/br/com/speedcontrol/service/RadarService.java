package br.com.speedcontrol.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.speedcontrol.dao.ISpeedDao;
import br.com.speedcontrol.dao.SpeedDao;
import br.com.speedcontrol.model.SpeedRadar;

public class RadarService implements IRadarService {
	
	private ISpeedDao speedDao;
	
	public RadarService() {
		speedDao = new SpeedDao();
	}

	public void registerSpeed(Timestamp time, float speed, List<String> tags) {
		speedDao.registerSpeed(time, speed, tags);
		
	}

	public List<SpeedRadar> retrieveSpeeds() {
		return speedDao.retrieveSpeeds();
	}
	
	private float speed() {
		float minX = 10.0f;
		float maxX = 200.0f;

		Random rand = new Random();

		float finalX = rand.nextFloat() * (maxX - minX) + minX;
		
		return finalX;
	}
	
	private Timestamp getCurrentTime() {
		 java.util.Date date= new java.util.Date();
		 return new Timestamp(date.getTime());
	}

	public SpeedRadar getSpeedRealTime() {
		float speed = speed();
		List<String> tags = new ArrayList<String>();
		
		if (speed > 50) {
			tags.add("fined");
		} else {
			tags.add("not fined");
		}
		
		Timestamp currentTime = getCurrentTime();
		SpeedRadar sr = new SpeedRadar();
		sr.setSpeed(speed);
		sr.setTime(currentTime);
		
		speedDao.registerSpeed(currentTime, speed, tags);
		
		return sr;
	}

	public List<SpeedRadar> getFinedSpeeds() {
		return speedDao.retrieveFinedSpeeds();
	}

	public List<SpeedRadar> getNotFinedSpeeds() {
		return speedDao.retrieveNotFinedSpeeds();
	}

}
