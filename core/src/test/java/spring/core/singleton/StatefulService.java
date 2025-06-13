package spring.core.singleton;

public class StatefulService {

//    //stateful한 변수
//    static private int price;
//
//    private StatefulService(){
//    }
//
//    public static void setPrice(int price){
//        StatefulService.price = price;
//    }
//
//    public static int getPrice(){
//        return price;
//    }

    //상태를 유지하는 필드
    private int price;

    public void order(String name, int price){
        System.out.println("(" + name + ") ordered (" + price + ") won");
        this.price = price;
    }

    public int getPrice(){
        return price;
    }


}
