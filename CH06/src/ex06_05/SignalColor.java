package ex06_05;

public class SignalColor {
	enum Signal{
		RED("RED"){
			public Color getColor(){
				return color;
			}
		},
		YELLOW("YELLOW"){
			public Color getColor(){
				return color;
			}
		},
		BLUE("BLUE"){
			public Color getColor(){
				return color;
			}
		};
	
		Color color;
		Signal(String color){
			this.color = new Color(color);
		}
		
		abstract public Color getColor();
	}
}
