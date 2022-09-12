package es.imatia.units;

public class Car {
	private String brand;
	private String model;
	private int maxSpeed = 120;
	private String fuel;
	private int speedometer = 0;
	private int tachometer = 0;
	private String gear = "N";
	private boolean reverse = false;
	private int steeringWheelAngle = 0;
	
	public Car(String brand, String model, int maxSpeed, String fuel) {
		this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.fuel = fuel;
	}
	
	public Car() {
		this.brand="";
		this.model="";
		this.maxSpeed = 0;
		this.fuel="";
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public int getSpeedometer() {
		return speedometer;
	}

	public void setSpeedometer(int speedometer) {
		this.speedometer = speedometer;
	}

	public int getTachometer() {
		return tachometer;
	}

	public void setTachometer(int tachometer) {
		this.tachometer = tachometer;
	}

	public int getSteeringWheelAngle() {
		return steeringWheelAngle;
	}

	public void setSteeringWheelAngle(int steeringWheelAngle) {
		this.steeringWheelAngle = steeringWheelAngle;
	}
	

	
	public void start() {
		if(this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Car starting");
		}
		else {
			System.out.println("Car is already started");
		}
	}
	
	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			System.out.println("Car is turned off");
		}
		else {
			System.out.println("Before turning off, car must stop");
		}
	}
		
	public void accelerate(int maxSpeed) {
		if (this.speedometer == maxSpeed) {
			System.out.println("Car is already at maximum speed");
		}
		else if(this.reverse && this.speedometer < 25) {
			this.tachometer += 5;
		}
		else {
			this.caculateTachometer();
		}
	}
	
	private void caculateTachometer() {
		double gearVel = (float) this.speedometer / 25;
		double gearVelInt = Math.floor(gearVel);
		this.gear = Integer.toString((int)(gearVelInt + 1));
		double fract = gearVel - gearVelInt;
		this.tachometer = (int)((fract * 100 * 1500)/100) + 1000;
	}
	
	public void brake() {
		if (this.speedometer == 0) {
			System.out.println("Car is stopped.");
		}
		else if (this.reverse){
			this.speedometer -= 5;
			this.tachometer = 1000;
			this.gear = "N";
		}
		else {
			this.caculateTachometer();
		}
	}
	
	public void turnSteeringWheel(int angle) {
		if (this.steeringWheelAngle > 45 || this.steeringWheelAngle < -45)
			System.out.println("SteeringWheel off limits");
		else {
			this.steeringWheelAngle = angle;
		}
	}
	
	public void showSteeringWheelDetail() {
		if (this.steeringWheelAngle < 0) {
			System.out.println("SteeringWheel is to left");
		}
		else if (this.steeringWheelAngle > 0) {
			System.out.println("SteeringWheel is to right");
		}
		else if (this.steeringWheelAngle == 0) {
			System.out.println("SteeringWheel is centered");
		}
		else {
			System.out.println(this.getSteeringWheelAngle());
		}
	}
	
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
		if (this.speedometer != 0) {
			System.out.println("Car is not stopped");
		}
		else if (this.reverse) {
			System.out.println("Gear is already reverse");
		}
		else if (!this.reverse) {
			System.out.println("Gear is not in reverse. Putting gear in reverse");
			this.gear = "R";
		}
	}
	
	public void showDetails() {
		System.out.println("Marca de conche: "+this.getBrand());
		System.out.println("Modelo de conche: "+this.getModel());
		System.out.println("Tipo de combustible: "+this.getFuel());
		System.out.println("Velocidad: "+this.getSpeedometer());
		System.out.println("Marcha: "+this.gear);
		this.showSteeringWheelDetail();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Car myCar = new Car("Citröen", "Xsara", 120 , "Diésel");
	
		String option="";
		
		System.out.println();
		
		do {
			System.out.println();
			
			myCar.showDetails();
			
			option = Input.string(		
			"Selección: \n '"
			+ "'+'- Acelerar\n "
			+ "'-'- Frear\n "
			+ "'n'- Marcha directa\n "
			+ "'r'- Marcha atrÃ¡s\n "
			+ "'d'- Xirar a dereita\n "
			+ "'i'- Xirar a esquerda\n "
			+ "'end' - Acaba o programa\n"
			+ "Qué opción desexa facer?: ");

			System.out.println();
			
			switch(option) {
			case "+":
				myCar.accelerate(120);
				break;
			case "-":
				myCar.brake();
				break;
			case "r":
				myCar.setReverse(true);
				break;
			case "n":
				myCar.setReverse(false);
				break;
			case "d":
				myCar.turnSteeringWheel(5);
				break;
			case "i":
				myCar.turnSteeringWheel(-5);
				break;
			case "end":
				break;
			default:
				System.out.println("Esa opción no existe");
				break;
			}		
		} while(!option.equalsIgnoreCase("end"));
	}
}
