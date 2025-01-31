package Datastructure.recursive;


public class RecursiveExample
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int result = fact(5);
		System.out.println(result);
		System.out.println(sum(5));
	    System.out.println(revNum(1,0));
	    System.out.println(revString("hello",""));

		
		
	}
	
	public static int fact(int n){
	    if( n <=1){
	        return 1;
	    }
	    return fact(n-1)*n;
	}
	
	public static int sum(int n){
	    if(n ==0){
	        return 0;
	    }
	    return sum(n-1)+n;
	}
	
	public static int revNum(int n, int rev){
	    if(n ==0){
	        return rev;
	    }
	    int lastDigit = n % 10;
	    rev = rev * 10+lastDigit;
	    return revNum(n/10,rev);
	    
	}
	
	public static String revString(String s, String rev){
	    if(s.isEmpty()){
	        return rev;
	    }
	    rev = rev+s.charAt(s.length()-1);
	    return revString(s.substring(0,s.length()-1),rev);
	}
	
}