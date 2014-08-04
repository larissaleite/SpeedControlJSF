package br.com.speedcontrol.service;

import java.sql.Timestamp;
import java.util.List;

import br.com.speedcontrol.model.SpeedRadar;

public interface IRadarService {
	
	public List<SpeedRadar> retrieveSpeeds();
	public void registerSpeed(Timestamp time, float speed, List<String> tags);
	public SpeedRadar getSpeedRealTime();
	public List<SpeedRadar> getFinedSpeeds();
	public List<SpeedRadar> getNotFinedSpeeds();

}
