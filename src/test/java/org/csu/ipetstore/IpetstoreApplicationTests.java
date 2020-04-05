package org.csu.ipetstore;

import org.csu.ipetstore.domain.*;
import org.csu.ipetstore.service.AccountService;
import org.csu.ipetstore.service.CartService;
import org.csu.ipetstore.service.CatalogService;
import org.csu.ipetstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.ipetstore.mapper")
@ComponentScan("org.csu.ipetstore.service")
class IpetstoreApplicationTests {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void testOrder(){
        List<Order> orders = orderService.getOrdersByUsername("admin");
        for (Order o:orders
             ) {
            System.out.println(o.getOrderDate());
        }

        System.out.println(orders.size());
//        Order order = orderService.getOrder(1001);
//        System.out.println(order.getBillAddress1() + " "+order.getCardType()+ " "+order.getLocale());
//
//        orderService.insertOrder(order);
    }

    @Test
    void testCart(){
        Item item = cartService.getItemByProductName("Finch");
        System.out.println(item.getItemId()+" ,"+item.getAttribute1());
//        Cart cart = new Cart();
//        Account account = new Account();
//        account.setUsername("abc123");
//        account.setPassword("abc123");
//        account = accountService.getAccount(account);
//
//        cart = cartService.getCartByAccount(account);
//        for (CartItem c:cart.getCartItemList()
//        ) {
//            System.out.println(c.getItem().getItemId()+ ", "+c.getQuantity() + ", "+c.getTotal());
//        }
//
//        cartService.updateCart(cart,account);
    }

    @Test
    void testAccount(){
        Account account = new Account();
        account.setUsername("abc123");
        account.setPassword("abc123");
        account = accountService.getAccount(account);
        if(account != null){
            System.out.println(account.getUsername() +", "+ account.isBannerOption());
        }
        System.out.println(accountService.getBannerName("FISH"));

//        account.setUsername("dgdddd");
//        account.setPassword("abc123");
//        accountService.insertAccount(account);
    }

    @Test
    void testCatalog(){
        System.out.println(catalogService.getItemQuantityById("EST-1"));

        String[] strings = catalogService.getAutoCompleteArray("a");
        for (String s:strings
        ) {
            System.out.println(s);
        }
//        List<Category>categoryList= catalogService.getCategoryList();
//        for (Category c:categoryList
//             ) {
//            System.out.println(c.getName());
//        }

//        Category c = catalogService.getCategory("CATS");
//        System.out.println(c.getDescription());

//        System.out.println(catalogService.getProduct("FI-FW-02").getName());
//        System.out.println();
//        List<Product> products = catalogService.getProductListByCategory("CATS");
//        for (Product p:products
//             ) {
//            System.out.println(p.getName());
//        }

//        List<Product> products = catalogService.searchProductList("c");
//        for (Product p:products
//             ) {
//            System.out.println(p.getName());
//        }

//        List<Item> items = catalogService.getItemListByProduct("K9-RT-02");
//        for (Item p:items
//             ) {
//            System.out.println(p.getItemId());
//        }

        System.out.println(catalogService.getItem("EST-10").getProduct().getName());
    }

}
