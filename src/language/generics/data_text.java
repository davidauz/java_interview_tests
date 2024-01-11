package language.generics;

public class data_text extends data_basic {
	private String m_text;
	public data_text(String t){m_text=t;}

	@Override
	public void show() {
		System.out.println(m_text+"\n");
	}
}


