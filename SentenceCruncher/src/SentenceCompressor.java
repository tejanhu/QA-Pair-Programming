import java.util.Scanner;

public class SentenceCompressor {

    private void checkSentence(String w,String w2){
        int iterations = 0;
        String temp = "";
        String temp2 = "";
        int position = 0;

        //check which word is shorter and set shortest length to number of iterations
        if(w.length() <w2.length()){
            iterations = w.length();
        }
        else{
            iterations = w2.length();
        }

        //go through words to find overlapping letters
        for (int i = 0; i <iterations+1; i++) {
            temp =  w.substring(w.length()-i,w.length());
            temp2 = w2.substring(0,i);

            if(temp.equals(temp2)){

                //if found save position (will only keep largest overlap)
                position = i;
            }
        }
        //if no overlap print word with a space
        if(position==0){
            System.out.print(w +" ");
        }
        //if overlap print first word with missing overlap
        else{
            System.out.print(w.substring(0,w.length()-position));
        }
    }

    public void getSentence(String w){

        //input string is turned to words
        String [] words = w.split(" ");

        //for all but last word try to find overlap
        for(int i =0; i<words.length-1;i++) {
            checkSentence(words[i],words[i+1]);
        }
        //for last word return word.
        checkSentence(words[words.length-1],"");
    }

    public void getUserSentence()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the sentence you wish to compact.");
        String s = sc.nextLine();
        getSentence(s);
    }
}
