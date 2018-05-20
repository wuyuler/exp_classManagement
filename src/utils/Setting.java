package utils;

import java.util.ArrayList;

public class Setting {

	final static public int numOfSubject = 4;
	final static public String[] allSubject = {"剑术","体术","霸气","忍术"};
	public static int getIdOfSubject(String nameOfSubject) {
		for(int i = 0;i<numOfSubject;i++) {
			if(allSubject[i].equals(nameOfSubject)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
}

