import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.awt.Desktop;


class source implements Serializable{
	
 private static final long serialVersionUID = 1L;
	
 public String id;	
 private String date;
 private String time;
 private String type;
 private String name;
 private String phone;
 private String email;
 private String address;
 public String Buf;
 
 
 
source(String id,String date, String time,String type,String name, String phone, String email, String address){
  
  this.id = id;
  this.date = date;
  this.time = time;
  this.type = type;
  this.name = name;
  this.phone = phone;
  this.email = email;
  this.address = address;
 }

source()
{
	
}

public String getId() {
	return id;
}

public String getDate() {
	return date;
}

public String getTime() {
	return time;
}

public String getType() {
	return type;
}

public String getName() {
	return name;
}

public String getPhone() {
	return phone;
}

public String getEmail() {
	return email;
}

public String getAddress() {
	return address;
}

public void showAll(){
  System.out.println("\t"+id+" | "+date+" | "+time+" | "+type+" | "+name+" | "+phone+" | "+email+" | "+address);
 }

public String show()
{
	Buf = "\n"+id+" | "+date+" | "+time+" | "+type+" | "+name+" | "+phone+" | "+email+" | "+address+"\n";
	return Buf;
	
}

}





//Class
public class CyberCrimeClass extends Thread{
static source sr = new source();
static Scanner sc = new Scanner(System.in); 
static Hashtable<String, source> hash; 
static Hashtable<String, String> hash1;
static String id = "CCB" ;
static String bid;
static String doi;
static String toi;
static String type;
static String name;
static String phone;
static String email;
static String address;
static int r;
public static void main(String[] args) {
    hash=fetch(); 
    char con='y';
    while(con=='y'){
     home();    
      }
    
     try{
      InputStreamReader isr=new InputStreamReader(System.in);
      System.out.print("Press y to continue:");
      con=(char)isr.read();
     }catch(IOException ie){}
     
     
    }
    
    
   
   public static void viewAll(){
	   clear();
	   System.out.println("\n\n\n\t\t\t\tList of all the Registered Complaints\n");
	   System.out.println("\t__________________________________________________________________________________________\n");
	   System.out.println("\n\n\n\tCASE ID | DATE OF INCIDENT | TIME OF INCIDENT | TYPE | NAME | MOBILE NUMBER | EMAIL | ADDRESS\n");
    
    if(hash!=null){
     
     for(Enumeration<String> e=hash.keys(); e.hasMoreElements();){
      source entry=hash.get(e.nextElement());
      entry.showAll();
      try {
		Thread.sleep(1300);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     }
    System.out.print("\n\n\n\n\t\t\t\tChoose anyone from the below:\n\t\t\t\t1.File a case\n\n\t\t\t\t2.Back\n\n\t\t\t\tEnter option number: ");
    int flag2 = sc.nextInt();
    switch(flag2) {
    case 1: fileCase();
    case 2: official();
    default: official();
    }
    clear();
    }
    else
    { 
   	   System.out.println("\n\n\n\t\t\t\t\tNo Records found!");
		sleep(1900);
		clear();
    }
   }
   
   
   public static void viewcomp()
   {
	   System.out.println("\n\n\n\t\t\t\tList of all the Registered Complaints\n");
  	   System.out.println("\t__________________________________________________________________________________________\n");
    if(hash!=null){
    	System.out.println("\n\n\n\tCOMPLAINT ID | DATE OF INCIDENT | TIME OF INCIDENT | TYPE | NAME | MOBILE NUMBER | EMAIL | ADDRESS\n");
      
     for(Enumeration<String> e=hash.keys(); e.hasMoreElements();){
      source entry=hash.get(e.nextElement());
      entry.showAll();
    }
    }
    else
    { 
   	  System.out.println("\n\n\n\t\t\t\t\tNo Records found!");
      sleep(1900);
   	  clear();
    }
   }
   
   public static void complaint(){
   
    if(hash==null) hash=new Hashtable<String,source>();
    try{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("\n\n\t\t\t\t\tCyber Crime Supervisory Artifice\n\n\n");
	System.out.println("\n\t\t\t\t\t Complaint Registration Form");
	System.out.println("\n\n\t\tComplaint details");
	System.out.print("\n\n\t\t\tSubject: ");
	@SuppressWarnings("unused")
	String sub = br.readLine();
	System.out.print("\n\t\t\tDate of Incident(DD/MM/YYYY): ");
	doi = br.readLine();
	System.out.print("\n\t\t\tTime of Incident(12 hours format): ");
	toi = br.readLine();
	System.out.print("\n\t\t\tType\n\t\t\t(Hacking, Identity theft,\n\t\t\t Transaction Fraud, Piracy etc.) : ");
	type = br.readLine();
	System.out.print("\n\t\t\tWrite Complaint: ");
	String complaint = br.readLine();
	System.out.println("\n\n\t\tPersonal details");
	System.out.print("\n\t\t\tName: ");
    name = br.readLine();    
    System.out.print("\n\t\t\tPhone Number: ");
    phone = br.readLine(); 
    System.out.print("\n\t\t\tEmail: ");
    email = br.readLine();
    System.out.print("\n\t\t\tAddress: ");
    address = br.readLine();
  Random rand = new Random();
	r = rand.nextInt(1000);
	bid = generateID(4);
	id = bid;
	source src = new source(id,doi,toi,type,name,phone,email,address);
    hash.put(id,src); 
    record(hash); 
    writeFile();
    writeComplaint(id,complaint);
    }catch(IOException e){
    	System.out.println("Your complaint is not registered");
    	System.out.println("Error occured!");
    }
   }
   
   public static void writeComplaint(String id,String s)
   {
	   try {
			String buf = id+".wcomp";
			BufferedWriter bw = new BufferedWriter(new FileWriter(buf,true));
			bw.write(s);
			bw.newLine();
			bw.newLine();
	            try{
	             bw.close();
	            } catch(Exception ex){
	                 
	            }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   
   public static void writeConclusion(String con,String id)
   {
	   try {
		    String dirName = "Closed Cases";
			String buf = "Closed_"+id+".con";
			File dir = new File(dirName);
			@SuppressWarnings("unused")
			File actualFile = new File(dir,buf);
			BufferedWriter bw = new BufferedWriter(new FileWriter(buf,true));
			bw.write(con);
			bw.newLine();
			bw.newLine();
	            try{
	             bw.close();
	            } catch(Exception ex){
	                 
	            }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   
   public static void complaint1(String key, String val){
	   
	    if(hash1==null) hash1 = new Hashtable<String,String>();
	    {
	    hash1.put(key, val);
	    record1(hash1);
        }
   }
   
   public static String generateID(int numOfCharacters) {
       StringBuffer buffer = new StringBuffer();
       Random random = new Random();
       char[] chars = new char[] {  'A', 'B', 'C', 'D', 'E', 'F',
               'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
               'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4',
               '5', '6', '7', '8', '9', '0' };
       buffer.append("CCB");
       for (int i = 0; i < numOfCharacters; i++) {
           buffer.append(chars[random.nextInt(chars.length)]);
           
       }
       return buffer.toString();
   }

   
   public static void writeFile()
	{
		
		try {
			String Buffer = id+" | "+doi+" | "+toi+" | "+type+" | "+name+" | "+phone+" | "+email+" | "+address+"\n";
			BufferedWriter bw = new BufferedWriter(new FileWriter("AllComplaints.txt",true));
			bw.write(Buffer);
			bw.newLine();
	            try{
	             bw.close();
	            } catch(Exception ex){
	                 
	            }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   


public static void delete(){
    if(hash!=null){
     int si=hash.size(); 
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Name:");
     String key=br.readLine();
     hash.remove(key); 
     if(hash.size()<si){
      record(hash);
      System.out.println("The entry has been deleted.");
     }
     else
      System.out.println("Wrong name");
     }catch(IOException ie){}
     
     
    }
  }
  
  
   public static void searchById(){
	 clear();
     if(hash!=null){
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("\n\n\t\t\t\tSearch a Complaint by an ID");
     System.out.print("\n\n\n\t\t\t\tEnter Complaint ID: ");
     String key = br.readLine();
     source cu = hash.get(key);
     if(cu!=null)
     {
    	 System.out.println("\n\n\t\t\t\tRecord Found!");
    	 System.out.println("\n\tCOMPLAINT ID | DATE OF INCIDENT | TIME OF INCIDENT | TYPE | NAME | MOBILE NUMBER | EMAIL | ADDRESS\n");
         cu.showAll();
         System.out.print("\n\n\n\n\t\t\t\tChoose anyone from the below:\n\t\t\t\t1.File this complaint\n\n\t\t\t\t2.Back\n\n\t\t\t\tEnter option number: ");
         int flag2 = sc.nextInt();
         switch(flag2) {
         case 1: fileCase();
         case 2: official();
         default: official();
         }
     } 
     else
     {
    	 System.out.println("\n\ns\t\t\t\tRecord not found");
    	 sleep(1900);
     }
     
      clear();
     }catch(IOException ie){
    	 System.out.println("Error in fetching data...");
     }
     
     clear();
    }
   }
   
   
   public static void record(Hashtable<String,source> obj){
    try{
    FileOutputStream fos=new FileOutputStream("Complaints.hash");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    oos.writeObject(obj);
    oos.flush();
    oos.close();
    }catch(IOException ie){}
    
   }
   
   public static void record1(Hashtable<String,String> obj){
	    try{
	    FileOutputStream fos=new FileOutputStream("CaseFiled.hash");
	    ObjectOutputStream oos=new ObjectOutputStream(fos);
	    oos.writeObject(obj);
	    oos.flush();
	    oos.close();
	    }catch(IOException ie){}
	    
	   }
   
 
   
   @SuppressWarnings("unchecked")
public static Hashtable<String, source> fetch(){

    Hashtable<String, source> case1 = null;
    try{
    FileInputStream fis=new FileInputStream("Complaints.hash");
    ObjectInputStream ois=new ObjectInputStream(fis);
    case1=(Hashtable<String, source>)ois.readObject();
    ois.close();
   
    }catch(Exception ie){}
    return case1;
    
   }
   
   public static void displayReport(String src){
	   
    try{
   
     if(Desktop.isDesktopSupported()){
      File f=new File(src);
      Desktop.getDesktop().open(f);
   
     }
    }catch(IOException ie){}
   }
   
   
   public static void fileCase()
   {
	   clear();
	   System.out.println("\n\n\t\t\t\tCyber Crime Supervisory Artifice\n\n\n");
	   System.out.println("\n\t\t\t\t\tFile a case");
	   if(hash!=null){
		     try{
		     viewcomp();
		     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		     System.out.print("\n\n\n\t\t\t\tEnter a complaint ID: ");	
		     String key = br.readLine();
		     source cu = hash.get(key);
		     if(cu!=null)
		     {
		    	 System.out.println("\n\t\t\t\tRecord found");
		    	 System.out.println("\n\n\tCOMPLAINT ID | DATE OF INCIDENT | TIME OF INCIDENT | TYPE | NAME | MOBILE NUMBER | EMAIL | ADDRESS");
		         cu.showAll();
		         String filed = cu.show();
		         complaint1(key,filed);
		         fir(filed);
		         file(key);
		     } 
		     else
		      System.out.println("\n\n\n\t\t\t\tRecord not found");
		     }catch(IOException ie){
		    	 System.out.println("\t\t\t\tError in fetching data");
		     }
		     
		     
		    }
	   else
	   {
		   System.out.println("\n\n\n\t\t\tNo registered complaints found");
			sleep(2000);
			clear();
	   }
	   
   }
   
   
   private static void file(String key) {
	   clear();
	   if(hash!=null){
		     int si=hash.size(); 
		     hash.remove(key); 
		     if(hash.size()<si){
		      record(hash);
		     }
		     else
		      System.out.println("Error");
		     
		     
		    }
}



private static void fir(String filed) {
	try {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("FIR.txt",true));
		bw.write(filed);
		bw.newLine();
            try{
             bw.close();
	         System.out.println("\n\n\n\n\t\t\t\tThe complaint has been filed successfully");
	         sleep(3000);
	         clear();
            } catch(Exception ex){
                 
            }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void sleep(int num)
{
	try {
		Thread.sleep(num);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void register(){
	   clear();
	   complaint();
	   clear();
	   System.out.println("\n\n\n\n\t\t\t\t\tComplaint registered successfully!");
	   System.out.println("\n\t\t\t\t\tComplaint id is: "+id);
	   sleep(3000);   
   }
   
   
   
   
   
   public static void authenticate() {
	    clear();
   	    System.out.println("\n\n\t\t\t\tCyber Crime Supervisory Artifice\n\n\n");
	    System.out.println("\n\n\t\t\t\tOfficial Login\n\n");
	   	System.out.print("\n\t\t\t\tUsername: ");
	   	String username = sc.next();
	   	System.out.print("\n\t\t\t\tPassword: ");
//	   	String password = sc.next();
	   	String password = readPassword();
	   	if(username.equals("user")&&password.equals("pass"))
	   	{
	   		clear();
	   		System.out.print("\n\n\n\n\t\t\t\tYou have successfully logged in");
			sleep(1500);
	   		official();
	   	}
	   	else
	   	{
	   		System.out.println("\n\n\t\t\t\tInvalid Username or Password!");
	   		System.out.print("\n\t\t\t\tEnter 0 to Exit or 1 to Login: ");
	   		int flag = sc.nextInt();
	   		if(flag == 1) {
	   			authenticate();
	   		}
	   		else
	   		{
	   			home();
	   		}
	   		
	   	}
		
	}
   
   private static void official() {
	   	clear();
	   	while(true)
	   	{
//	   	clear();
	   	System.out.println("\n\n\t\t\t\t\tCyber Crime Supervisory Artifice\n\n\n");
		System.out.println("\t\t\t\t\t1.Check registered complaints\n");
		System.out.println("\t\t\t\t\t2.Check by ID\n");
		System.out.println("\t\t\t\t\t3.File a case\n");
//		System.out.println("\t\t\t\t\t4.Check all filed cases\n");
		System.out.println("\t\t\t\t\t4.Close a case\n");
		System.out.println("\t\t\t\t\t5.Logout\n");
		System.out.println("\t\t\t\t\t6.Exit\n");
		System.out.print("\n\n\t\t\t\t	Enter your choice(1-6): ");
		int ch = sc.nextInt();
		switch(ch)
		{
		   case 1: viewAll();
		   		   break;
		   case 2:searchById(); 
			      break;
		   case 3:fileCase();
		   		  break;
//		   case 4:viewcomp();
//		          break;
		   case 4:closeCase();
		   		   break;
		   case 5: {clear();
		   		   System.out.println("\n\n\t\t\t\t\tLogout Successful!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		       authenticate();
		   		   break;}
		   case 6:  home();
		   			break;
		   default: return;
		}
	   	}
	}
   
   
   private static void closeCase() {
	    
	   System.out.println("\n\n\t\t\t\tClose a case");
	   System.out.println("\n\n");
	   if(hash1!=null){
		     int si=hash1.size(); 
		     try{
		     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		     System.out.println("\t\t\t\tCase ID: ");
		     String key=br.readLine();
		     hash1.remove(key); 
		     if(hash1.size()<si){
		      System.out.println("Conclusion note: ");
		      String writeConclusion = br.readLine();
		      writeConclusion(writeConclusion,key);
		      record1(hash1);
		      System.out.println("The  has been deleted.");
		     }
		     else
		     {
		      clear();
		      System.out.println("This ID "+key+" is not found in filed Complaints. Either it may be closed or not yet filed.");
		      sleep(1600);
		     }
		     }catch(IOException ie){}
		    }
	   else
	   {
		      clear();
	          System.out.println("\n\n\n\n\n\t\t\t\t\tNo Records found!");
	          sleep(1800);
	          clear();
	   }
}



public static void status() {
	   clear();
	     if(hash1!=null){
	     try{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     System.out.println("\n\n\t\t\t\tComplaint Status");
	     System.out.println("\n\t_________________________________________________________________________________");
	     System.out.print("\n\n\n\t\t\t\tEnter Complaint ID: ");
	     String key = br.readLine();
	     String cu = hash1.get(key);
	     if(cu!=null)
	     {
	    	 System.out.println("\n\n\t\t\t\tYour complaint (Compalint ID "+key+" ) has been filed. It is under process.");
	    	 
	     } 
	     else
	     {
	    	 System.out.println("\n\n\t\t\t\tYour complaint is not yet filed. We will intimate you once filed\n\n\t\t\t\tTHANK YOU");
	    	 System.out.println("Thank You!");
	     }
	      System.out.println("\n\n\t\t\t\tEnter any number and press Enter to continue...");
	      @SuppressWarnings("unused")
		int flag3 = sc.nextInt();
	      clear();
	     }catch(IOException ie){
	    	 System.out.println("Error in fetching data...");
	     }
	     
	     clear();
	    }
	     else
	     {
	    	 clear();
	    	 System.out.println("\n\n\n\n\t\t\t\tNo records found! Your complaint is not yet filed.");
	    	 sleep(1900);
	     }
   }
   
   

 public static void home() 
  { 
	while(true)
	{
	clear();
	System.out.println("\n\n\t\t\t\t\tCyber Crime Supervisory Artifice\n\n\n");
	System.out.println("\t\t\t\t\t1.Register a complaint\n");
	System.out.println("\t\t\t\t\t2.Show Complaint Status\n");
	System.out.println("\t\t\t\t\t3.Official login\n");
	System.out.println("\t\t\t\t\t4.Exit");
	System.out.print("\n\n\t\t\t\t	Enter your choice(1-4): ");
	int ch = sc.nextInt();
	switch(ch)
	{
	   case 1: 	register();
	   		   	break;
	   		   	
	   case 2: 	status();
	   			break;
	   			
	   case 3: 	authenticate();
	   		   	break;
	   		   	
	   case 4:	clear();
				sleep(1100);
				System.out.println("\n\n\n\n\n\t\t\t\t\tExiting...");
				sleep(2300);
				System.exit(0);
				break;
				
	   default: System.out.print("\n\n\n\n\t\t\t\t\tYou have entered an invalid choice!");
	   			break;
	}
    }
  }

public static void clear()
	{
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static void staticScreen() {
	clear();
	sleep(1100);
	System.out.println("\n\n\n\n\n\t\t\t\tExiting...");
	sleep(2300);
	System.out.println("\n\n\n\n\n\t\t\t\tCyber Crime Supervisory Artifice");
	System.exit(0);
}



public static String readPassword () {
    EraserThread et = new EraserThread();
    Thread mask = new Thread(et);
    mask.start();

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String password=" ";

    try {
        password = in.readLine();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    et.stopMasking();
    return password;
 }
}   

class EraserThread implements Runnable {
 private boolean stop;

 public EraserThread(String prompt) {
    
 }

 public EraserThread() {
	// TODO Auto-generated constructor stub
}

@SuppressWarnings("static-access")
public void run () {
    while (!stop){
       System.out.print("\010*");
       try {
          Thread.currentThread().sleep(1);
       } catch(InterruptedException ie) {
          ie.printStackTrace();
       }
    }
 }

 public void stopMasking() {
    this.stop = true;
 }
}

