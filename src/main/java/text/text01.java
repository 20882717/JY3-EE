package text;

import com.neuedu.dao.*;
import com.neuedu.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class text01 {

//    private DataDao dataDao;

    private SqlSessionFactory sqlMapConfig = null;

    @Before
    public void before()
    {

        try {
            sqlMapConfig = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1");

    }


    @Test
    public void text() {

        SqlSession sqlSession = sqlMapConfig.openSession();
        UsersDao mapper = sqlSession.getMapper(UsersDao.class);
//        List<Orders> allOrders = mapper.getAllOrders();
//        System.out.println(allOrders);
//        Data users = mapper.getUsers("001");
//        System.out.println(users);
//        Data data = new Data("009", "005", "789", Times.getTime("2017-05-26"));
//        mapper.insertOneUser(data);
//        mapper.delOneUser("002");
//        QueryVo queryVoDao = new QueryVo();
//        Data data = new Data();
//        data.setUsername("5");
//        queryVoDao.setData(data);
//        List<Data> dataByName = mapper.getDataByName(queryVoDao);
//        System.out.println(dataByName);
//        Users users = new Users();
//        users.setSex('1');
//        users.setUsername("%张%");
//        List<Users> userBySexAndName = mapper.getUserBySexAndName(users);
//        System.out.println(userBySexAndName);
//        QueryVo queryVo = new QueryVo();
//        ArrayList<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(10);
//        ids.add(24);
//        queryVo.setIds(ids);
//        List<Integer> userById = mapper.getUserById(queryVo);
//        System.out.println(userById);
//        List<OrderUser> orderAndUser = mapper.getOrderAndUser();
//        System.out.println(orderAndUser);
//        List<Orders> ordersAndUsers = mapper.getOrdersAndUsers();
//        System.out.println(ordersAndUsers);

        List<Users> idByUsers = mapper.getIdByUser(1);
        System.out.println(idByUsers);

        System.out.println("===============================================");

        List<Users> idByUsers2 = mapper.getIdByUser(1);
        System.out.println(idByUsers2);


        sqlSession.commit();

        System.out.println("2");



    }
    @After
    public void after()
    {
        System.out.println("3");
    }
}
