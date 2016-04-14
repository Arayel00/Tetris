
public class Horloge {
	
	private static final long speed = 1;
	
	private long start;
	//private long current;
	
	public void Horloge(){
		
	}
	
	public void init(){
		start = System.nanoTime();
	}
	
	public boolean cycleDone(long time){
		if((time-start)/1.0E09>speed){
			start=System.nanoTime();
			return true;
		}
		return false;
	}
		

}
