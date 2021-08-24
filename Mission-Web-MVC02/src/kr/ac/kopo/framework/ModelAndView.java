package kr.ac.kopo.framework;

import java.util.HashMap;
import java.util.Map;

/*
 	Model	: 화면단(JSP)에서 사용한 데이터 저장객체(request 공유영역에 등록한 객체)
 	View	: 응답화면(JSP) 정보 저장
 */

public class ModelAndView {

	private String view;
	private Map<String, Object> model;
	
	public ModelAndView() {
		model = new HashMap<>();
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public void addAttribute(String key, Object value) {
		model.put(key, value);
	}
}






