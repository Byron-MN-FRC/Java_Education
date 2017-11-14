package java_tutorial.dog;

public class Dog {
    private int legs = 4;
    private int eyes = 2;
    private int heartRate = 75; 
	public int getHeartRate() {
		return heartRate;
	}

	private void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
     
    String name = new String("Rufus");
    
    public void Bark() {
    	System.out.println("Woof!");
    }
    
    public void Move(int speed) {
    }
    
    int ChangeHeartRate (int newHeartRate) {
    	if ((newHeartRate < 50) || (newHeartRate > 200))
    	{
    		System.out.println("##################################################################################");
    		System.out.println("You cannot set the dog's heart rate to " + newHeartRate + ".  It is too dangerous!");
    		System.out.println("##################################################################################");
    	}
    	else
    	{
    		this.setHeartRate(newHeartRate);
    	}
    	return heartRate;
    }

   
}

