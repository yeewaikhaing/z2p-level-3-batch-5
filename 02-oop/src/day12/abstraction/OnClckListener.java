package day12.abstraction;

public interface OnClckListener {

	int FONT_SIZE = 12;
	String FONT_FAMILY = "Arial";
	
	void onClick();
	void onDoubleClick();
}
class Button implements OnClckListener{
	
	private String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("Button name: " + name);
		System.out.println("Font size: " + FONT_SIZE);
		System.out.println("Font family: " + FONT_FAMILY);
	}
	
	@Override
	public void onClick() {
		System.out.println("This is onClick method");
	}

	@Override
	public void onDoubleClick() {
		System.out.println("This is onDoubleClick method");
		
	}
}
