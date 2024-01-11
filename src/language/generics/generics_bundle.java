package language.generics;

import java.util.ArrayList;

public class generics_bundle<T extends data_basic> {

	private ArrayList<T> m_data_list=new ArrayList<>();

	public void add_element(T t){
		m_data_list.add(t);
	};

	public void show() {
		for(data_basic db : m_data_list){
			db.show();
		}
	}
}
