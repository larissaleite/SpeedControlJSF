package br.com.speedcontrol.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;

import br.com.speedcontrol.model.SpeedRadar;

@ManagedBean
public class SpeedMBean {
	
	//private IRadarService radarService;
		
	public SpeedMBean(){
		//radarService = new RadarService();
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
	
	public SpeedRadar speedGenerator() {
		
		//for (;;) {
			
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			float speed = speed();
			List<String> tags = new ArrayList<String>();
			
			if (speed > 50) {
				tags.add("fined");
			} else {
				tags.add("not fined");
			}
			
			System.out.println("Speed "+speed);
			//radarService.registerSpeed(getCurrentTime(), speed, tags);
			SpeedRadar sr = new SpeedRadar();
			sr.setSpeed(speed);
			sr.setTime(getCurrentTime());
			
			return sr;
		}
	//}

}
