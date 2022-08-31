public class AsciiChars 
{
  public static void printNumbers()
  {
	  //ASCII #48-57 = digits
	  for(int c = 48; c < 57; ++c) {
		  System.out.print((char)c + ", ");
	  }
	  //prints last char without comma after it
	  int c = 57;
	  System.out.print((char)c);
	  
	  //creates some space between sections
	  System.out.println("\n");
  }

  public static void printLowerCase()
  {
	  //ASCII #97-122 = lowercase letters
	  for(int c = 97; c < 122; ++c) {
		  System.out.print((char)c + ", ");
	  }
	  //prints last char without comma after it
	  int c = 122;
	  System.out.print((char)c);
	  
	  //creates some space between sections
	  System.out.println("\n");
  }

  public static void printUpperCase()
  {
	  //ASCII #65-90 = uppercase letters
	  for(int c = 65; c < 90; ++c) {
		  System.out.print((char)c + ", ");
	  }
	  //prints last char without comma after it
	  int c = 90;
	  System.out.print((char)c);
	  
	  //creates some space between sections
	  System.out.println("\n");
  }
}//end of AsciiChars class
