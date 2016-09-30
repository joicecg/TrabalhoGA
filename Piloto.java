package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public class Piloto implements Comparable<Piloto> {
	private String numCar;
	private String driver;
	private String team;
	private String laps;
	private String timeOrRetired;
	private String grid;
	private int pts;
	
	public Piloto() {
		
	}
	
	public Piloto(String numCar, String driver, String team, String laps, String timeOrRetired, String grid, int pts) {
		this.numCar = numCar;
		this.driver = driver;
		this.team = team;
		this.laps = laps;
		this.timeOrRetired = timeOrRetired;
		this.grid = grid;
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
	
	//DAQUI EM DIANTE SÓ MÉTODOS DE ACESSO
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

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}
}