package kr.ac.kopo.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.framework.annotation.RequestMapping;

public class HandlerMapping {

	private Map<String, CtrlAndMethod> mappings;
	
	public HandlerMapping(String ctrlNames) throws Exception {
		// ctrlNames => kr.ac.kopo.board.controller.BoardController|kr.ac.kopo.login.controller.LoginController
		
		mappings = new HashMap<>();
		
		String[] ctrls = ctrlNames.split("\\|");
		
		for(String ctrl : ctrls) {
	//		System.out.println(ctrl.trim());
			Class<?> clz = Class.forName(ctrl.trim());
			
//			Object target = clz.newInstance();
			Object target = clz.getDeclaredConstructor().newInstance();
			
			Method[] methods = clz.getMethods();
//			Method[] methods = clz.getDeclaredMethods();
			for(Method method : methods) {
//				System.out.println(method);
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
				
				if(reqAnno != null) {
					String uri = reqAnno.value();
//					System.out.println("uri : " + uri);
					
				 	CtrlAndMethod cam = new CtrlAndMethod(target, method);
					mappings.put(uri, cam);
				}
			}
		
			System.out.println();
		}
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
}















