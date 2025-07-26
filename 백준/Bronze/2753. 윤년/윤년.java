import java.util.Scanner;

public class Main{
    
    
    public static void main(String[] args){
    
    
        // 윤년인지 아닌지 판별하는 프로그램

        int number;


        Scanner sc = new Scanner(System.in);



        number=sc.nextInt();

        Year year = new Year(number);

        // 4로 나누어 떨어지면 윤년 , 400으로 떨어지면 윤년  , 이 둘중 하나면 윤년 
        // 100으로 나눠 떨어지면 평년 

        if(year.isLeafYear())
            System.out.println("1");
        else 
            System.out.println("0");
    
    }



}


class Year{

    private int year;

    public Year(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeafYear(){

        if ((getYear() % 4 == 0 && getYear() % 100 != 0) || (getYear() % 400 == 0))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(getYear());
    }


    
}