package hyeonjeongs.spring_principle.singleton;

public class StatafulService {

    //private int price; //상태 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        //this.price = price;
        return price;
    }


}
