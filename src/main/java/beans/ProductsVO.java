package beans;

import java.util.Objects;

public class ProductsVO extends Object {

    // 여기서 최종 고정값으로 만들려면 final 붙여서 선언해주고
    // => setter 를 만들지 않아야 완벽한 final 값이 된다.
    // final 걸고 setter 안만들기


    private Long productId;
    private String productName;
    private Integer price;

    public ProductsVO() {}
    // single tone 으로 막아두르면 private 인데, 이렇게 할때도 기본생성자는 만들어 두자.

    public ProductsVO(String productName, Integer price) {
        this.productId = 1L;
        this.productName = productName;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("상품번호: %d, 상품명: %s, 상품가격: %d원",
                productId, productName, price);
    }

/*
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductsVO)) {
            return false; // 같은 종류의 객체 instance 가 아니라면 비교조차 할 필요가 없다.
        }
        ProductsVO target = (ProductsVO) obj;
        return this.productId == target.productId
                && this.productName == target.productName
                && this.price == target.price;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsVO that = (ProductsVO) o;
        return productId.equals(that.productId) && productName.equals(that.productName) && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price);
    }
}
