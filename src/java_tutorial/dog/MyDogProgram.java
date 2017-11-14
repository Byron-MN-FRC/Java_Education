package java_tutorial.dog;

import java.util.Scanner;

public class MyDogProgram {

	public static void main(String[] args) { 
		Dog myDog = new Dog();
		System.out.println("My Dog's heart rate is " + myDog.getHeartRate());
		Scanner in = new Scanner(System.in);
		int newHeartRate = 0;
		while (newHeartRate >= 0)
		{
			System.out.print("\n\n");
			System.out.print("Enter a new heart rate for this dog (negative value to exit):  ");
			newHeartRate = in.nextInt();
			myDog.ChangeHeartRate(newHeartRate);
			System.out.println("It's heart rate is now " + myDog.getHeartRate());
		}
		in.close();
		myDog.Bark();
		myDog.Bark();
		myDog.Bark();
		myDog.Bark();
		myDog.Bark();
		myDog.Bark();
		
    }  
}
