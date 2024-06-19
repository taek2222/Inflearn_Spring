package hello.core.singleton;

public class StatefulService {

    /**
     * 스프링 빈에 아래와 같이 공유 필드를 해놓으면 심각한 오류가 발생할 수 있다.
     * 무조건, 조심해야한다.
     * 공유 필드를 지역 변수로 변경하면 해결할 수 있다.
     */
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
