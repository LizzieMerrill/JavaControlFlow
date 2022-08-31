public class AsciiChars 
{
  public static void printNumbers()
  {
	  //ASCII #48-57 = digits
	  for(int c = 48; c < 58; ++c) {
		  System.out.println((char)c);
	  }
  }

  public static void printLowerCase()
  {
	  //ASCII #97-122 = lowercase letters
	  for(int c = 97; c < 123; ++c) {
		  System.out.println((char)c);
	  }
  }

  public static void printUpperCase()
  {
	  //ASCII #65-90 = uppercase letters
	  for(int c = 65; c < 91; ++c) {
		  System.out.println((char)c);
	  }
  }
}//end of AsciiChars class
