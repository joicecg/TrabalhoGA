package JoiceAndersonTrabGA;

public class Piloto implements Comparable<Piloto> {
	String numCar, driver, team, laps, timeOrRetired, gridPos;
	int pts;
	public String getNumCar() {
		return numCar;
	}
	public void setNumCar(String numCar) {
		this.numCar = numCar;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getLaps() {
		return laps;
	}
	public void setLaps(String laps) {
		this.laps = laps;
	}
	public String getTimeOrRetired() {
		return timeOrRetired;
	}
	public void setTimeOrRetired(String timeOrRetired) {
		this.timeOrRetired = timeOrRetired;
	}
	public String getGridPos() {
		return gridPos;
	}
	public void setGridPos(String gridPos) {
		this.gridPos = gridPos;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public int compareTo(Piloto o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this.getPts() <  o.getPts())
	    	return BEFORE;
	    
	    else if(this.getPts() == o.getPts())
	    	return EQUAL;
	    
	    else return AFTER;
	}
}
