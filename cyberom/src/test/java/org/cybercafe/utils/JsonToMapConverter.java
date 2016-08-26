package org.cybercafe.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonToMapConverter {
	
	public static Map<String, Object> toMap(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> keyIterator = jsonObject.keys();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			map.put(key.toUpperCase(), getValue(jsonObject.get(key)));
		}
		return map;
	}

	private static List<Object> toList(JSONArray array) {
		List<Object> list = new ArrayList<Object>();
		for(int i=0;i<array.length();i++) {
			list.add(getValue(array.get(i)));
		}
		return list;
	}
	
	private static Object getValue(Object value) {
		if(value instanceof JSONArray) {
			value = toList((JSONArray)value);
		}
		if(value instanceof JSONObject) {
			value = toMap((JSONObject)value);
		}
		return value;
	}

}
