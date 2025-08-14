package labassignments;
 //@author sianna
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CaeserCipher_Ferguson {
    
    public static void main(String[] args) {
        File file=new File("passwords.txt");
        Scanner scan;
        String Pass;
        String decryptedPass="";
        int shift=5;
        //try and read file
        try{
            scan=new Scanner(file);
            System.out.println(file+" found and open");
            
            //read file
            while(scan.hasNext()){
                Pass=scan.next().toLowerCase();
                decryptedPass+=decrypt(Pass, shift)+"\n";   
            }
            System.out.println(decryptedPass);
        }catch(FileNotFoundException fne){
            System.out.println(file+" not found");
        }
    }
    public static String decrypt(String pass, int shift){
        char[] letters="abcdefghijklmnopqrstuvwxyz".toCharArray();
        String decrypted="";
        int letterPos;
        char currentChar;
        int sub;
        for (int i = 0; i < pass.length(); i++) {
            //ith number 
            currentChar=pass.charAt(i);
            //find index of char in array
            letterPos=String.valueOf(letters).indexOf(currentChar); //returns int (index)
            //add shift
            sub=letterPos-shift;
            //validate shift going negative
            if(sub<0){
               sub=letters.length+sub; 
            } 
            //add shifted letters to string
            decrypted+=letters[sub];
        }
        return decrypted;
    }
}
