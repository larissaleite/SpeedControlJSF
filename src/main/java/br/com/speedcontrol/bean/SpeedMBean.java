package br.com.speedcontrol.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.speedcontrol.model.SpeedRadar;

@ManagedBean
public class SpeedMBean {
	
	//private ISpeedDao speedDao;
	
	private List<SpeedRadar> speedList;
	
	public SpeedMBean(){
		//speedDao = new SpeedDao();
		//setSpeedList(speedDao.retrieveSpeeds());
	}

	public List<SpeedRadar> getSpeedList() {
		return speedList;
	}

	public void setSpeedList(List<SpeedRadar> speedList) {
		this.speedList = speedList;
	}
	
	public void generator() {}

}
