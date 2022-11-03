package day12.abstraction;

public class Demo {

	public static void main(String[] args) {
		//OnClckListener obj = new OnClckListener();
		
		OnClckListener btn1 = new Button("btn-login");
		
		btn1.onClick();
		btn1.onDoubleClick();
	
		
		Button btn2 = new Button("btn-logout");
		btn2.display();
		btn2.onClick();
		btn2.onDoubleClick();
	}
}
