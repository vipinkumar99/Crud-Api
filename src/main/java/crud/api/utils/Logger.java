package crud.api.utils;

public class Logger{
	public static void log(Object obj) {
		System.out.println(obj);
	}
	
	public static void logErr(Exception ex) {
		System.out.println("Error : " + ex.getMessage());
		ex.printStackTrace();
	}

}
