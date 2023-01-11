package itcen;

import beans.ProductsVO;

import java.util.HashSet;
import java.util.Set;

public class ProductController {
    public static void main(String[] args) {
        ProductsVO product1 = new ProductsVO("세탁기", 300000);
        ProductsVO product2 = new ProductsVO("세탁기", 300000);


        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1.equals(product2));


/*
        System.out.println(productsVO.hashCode());
        System.out.println(Integer.toHexString(productsVO.hashCode()));
*/

        Set<ProductsVO> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);

        System.out.println(productSet.size());

        // 객체는 서로 다른걸로 취급한다. ( Hashcode 가 서로 다른 상태 )
        // -> Java 는 서로 다른 객체로 취급
        // => 필드값이 같으면 HashCode 까지 일치시켜주는 처리를 하면 필드값 같으면 객체도 같은거로 인식시킴

        // => equals 오버라이드 해서 사용할거면 => hashcode 도 세트로 해서 같이 맞춰줘야 객체를 동일 객체로 인식해준다.









    }
}
