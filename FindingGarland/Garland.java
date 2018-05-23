import java.util.ArrayList;

public class Garland {

    private String word;
    public Garland(){

    }

    public static void checkIfGarland(){

        String s = "";
        int degree = 0;
        int i=1;
        while((s.substring(i)).contains(s.substring(0,i-1))){
            degree++;
            i++;
        }

        System.out.println(degree-1);














//        String[] ch = userInput.split("");
//        ArrayList<String> list = new ArrayList<String>();
//        for(String s : ch){
//            list.add(s);
//        }
//        int i=0;
//        int index=0;
//        int degree=0;
        /*while(list.subList(i+1,list.size()).contains(list.get(i))){
            index = list.subList(i+1,list.size()).indexOf(list.get(i));

            i++;
        }*/


    }
    public static void main(String[] args) {
        checkIfGarland();
    }
}

