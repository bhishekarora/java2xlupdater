import java.io.File;
import java.io.IOException;
class Files {


    public static void main (String args[]) throws IOException{
    	String dir = System.getProperty("user.dir");
    	
File folder = new File(dir+"\\docs");
File[] listOfFiles = folder.listFiles();
if(listOfFiles.length ==0) {
    System.out.println("docs directory empty ");
	return;
	
}
String originalName,newName;

for (int i = 0; i < listOfFiles.length; i++) {
  if (listOfFiles[i].isFile()) {
    originalName =listOfFiles[i].getName();
    File origFile = new File(dir+"\\docs\\"+originalName);
    newName= RemoveSpecialCharacters.removeIllegalCharacters(originalName,true);
    
  
    File newFile= new File (dir+"\\output\\"+newName);
    System.out.println("File " +  newFile);


   
    if(origFile.renameTo(newFile)){
        UpdateXL.update(originalName,newName);
        System.out.println("File rename success for " + newName);
    }else{
        System.out.println("File rename failed");
    }


  } else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
  }
}


    }

}