import java.util.*;
public class Trees {
	
	public interface Interface1{void method1();}
	public interface Interface2 extends Interface1{void method2();}
	
	public class Class1 implements Interface1{
		public void method1(){};
		public void method2(){};
	}
	
	public class Class2 extends Class1 implements Interface2{
		public Class2(){}
	}
	
	
	public static void main(String[] args){
		try (Class2 myClass = new Class2()){
			System.out.println("hi");
		}
		catch(Exception e){
			System.out.println("Error");			
		}	
		
	}

}
