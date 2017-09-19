import com.model.User;
import com.mongodb.*;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangheng on 2017/8/7.
 */
public class TestDb {
    ClassPathXmlApplicationContext context;
    UserService userService;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext(new
                String[]{"classpath:applicationContext-mongo.xml",
                "classpath:springmvc.xml"});
        userService = (UserService) context.getBean("userService");
    }

    public static void main(String[] args) {

    }
    @Test
    public void testMongodb(){
        try{
            List<User> list = userService.findAll("user");
//            list.setId(null);
//            list.setEmail("aaa22222a@qq.com");
//            userService.insert(list,"zh");
//            for (User user:
//                 list) {
                System.out.println(list.get(0).getEmail()+":"+list.get(0).getId());
//            }

            Mongo mongo = new Mongo("127.0.0.1",27017);
            DB db = mongo.getDB("zh");
            Set<String> names = db.getCollectionNames();
            names.forEach(System.out::println);
//            DBCollection dbCollection = db.getCollection("test");
//            for (int i = 0; i < 1000000; i++) {
//                dbCollection.insert(BasicDBObject.parse("{_id:"+i+",key:\"a"+i+"\",value:"+i+"}"));
//            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
