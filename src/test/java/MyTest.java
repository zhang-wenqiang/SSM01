import com.zhang.entity.Book;
import com.zhang.service.BookService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *   时间：2021/12/9
 *
 *
 */
public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookServiceImpl");
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }


    //判断多个字符串中有没有null值，“”不能判断出来

    @Test
    public void test2() throws Exception {
        Stream<String> aaa = Stream.of("1",null,null);
        List<String> collect = aaa.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return StringUtils.isEmpty(s);
            }
        }).collect(Collectors.toList());
        System.out.println(collect);
        if (1==1){
            throw new Exception();
        }
        System.out.println(111);
    }


    @Test
    public void test3(){
        Map<String,Object> map = new HashMap<>();

        map.put("123",132);
        map.put("321",123);
        System.out.println(map);

        System.out.println(map.get("123") instanceof Integer);
    }


    @Test
    public void test4(){
        //Optional类
        Book book = new Book(1,"红楼梦",99,"四大名著之一");
        Optional<Book> book1 = Optional.ofNullable(book);

        System.out.println("Optional类："+(book1.get() instanceof Book));
        System.out.println("Optional类："+book1.get().getBookName());
        System.out.println("Optional类："+book1.map((a)->Optional.ofNullable(a.getDetail())).get().get());

        //接口默认方法
        TT tt = new TT();
        tt.test1();
        //接口静态方法
        TTT.test2();

        //函数式接口
        test5(a->{
            System.out.println(a);
        });
        //泛型
        List<Object> list = new ArrayList<>();
        test6(list);


        List<?> list1 = new ArrayList<>();


    }

    public void test5(C c){
        c.t("函数式接口");
    }

    public void test6(List<? super Number> list){
        System.out.println("泛型：下界通配符super");
    }



}
//继承和实现要分清，要不然接口就失去了它存在的意义
interface TTT{
    public static final int a = 1;//接口中变量必须是public static final类型

    public default void test1(){    //default可以让接口中有实现的方法
        System.out.println("接口默认方法");
    }


    static void test2(){
        System.out.println("接口静态方法");
    }

}

//函数式接口：有且只有一个抽象方法，能被lambda表达式简化
//该注解表明当前是一个函数式接口，会检查是不是有且只有一个抽象方法
@FunctionalInterface
interface C{
    public abstract void t(String a);


}

class TT extends T implements TTT{

    public void test(){
        System.out.println("接口中的常量a=>"+a);
        System.out.println("父类中的常量b=>"+b);
    }
}


class T<T> implements C{

    private T a;

    protected static final int b = 1;

    @Override
    public void t(String a) {
        System.out.println("实现接口C中方法");
    }


    public T getA() {
        return a;
    }


}

class T2<T> implements Serializable {

    //泛型通配符是用于解决泛型之间引用传递问题
    public void test(List<?> list,Map<?,?> map){
        System.out.println(list.get(1));

    }
}





