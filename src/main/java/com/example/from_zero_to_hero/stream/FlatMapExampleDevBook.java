package com.example.from_zero_to_hero.stream;

import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExampleDevBook {
    public static void main(String[] args) {

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/

        Set<String> collect =
                list.stream()
                        .map(Developer::getBook)                            //  Stream<Set<String>>
                        .flatMap(Collection::stream)                        //  Stream<String>
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);

    }
}

class FlatMapExample2 {

    public static void main(String[] args) {
        List<Order1> orders = findAll();

        /*
            Stream<List<LineItem>> listStream = orders.stream()
                    .map(order -> order.getLineItems());

            Stream<LineItem> lineItemStream = orders.stream()
                    .flatMap(order -> order.getLineItems().stream());
        */

        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())    //  Stream<LineItem>
                .map(line -> line.getTotal())                       //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal())                     //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

        if (!sumOfOrder.equals(sumOfLineItems)) {
            System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
        }
    }

    private static List<Order1> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order1 order1 = new Order1(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order1 order2 = new Order1(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order1 order3 = new Order1(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }


}

class LineItem {

    private Integer id;
    private String item;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;

    public LineItem(Integer id, String item, Integer qty, BigDecimal price, BigDecimal total) {
        this.id = id;
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public LineItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

class Order1 {
    private Integer id;
    private String invoice;
    private List<LineItem> lineItems;
    private BigDecimal total;

    public Order1(Integer id, String invoice, List<LineItem> lineItems, BigDecimal total) {
        this.id = id;
        this.invoice = invoice;
        this.lineItems = lineItems;
        this.total = total;
    }

    public Order1() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

class Developer {

    private Integer id;
    private String name;
    private Set<String> book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
