import com.dao.daoimpl.ContentDao;
import com.model.Content;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.service.ContentService;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by zhangheng on 2017/8/7.
 */
public class TestDb {
    ClassPathXmlApplicationContext context;
    UserService userService;
    ContentService contentService;
    ContentDao contentDao;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext(new
                String[]{"classpath:applicationContext-mongo.xml",
                "classpath:springmvc.xml"});
        contentDao = (ContentDao) context.getBean("contentDao");
//        userService = (UserService) context.getBean("userService");
//        contentService = (ContentService) context.getBean("contentService");
    }

    public static void main(String[] args) {

    }
    @Test
    public void testMongodb(){
        for (int i = 3; i < 9; i++) {
            Content content = new Content();
            content.setCreated(LocalDate.now());
            content.setContent(i+"今夜阳光明媚啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            content.setCoverUrl("images/pic_"+i+".jpg");
            content.setSlug("初体验"+i);
            content.setTitle("晚上的初体验"+i);
            content.setType(Arrays.asList("node","bobo"));
            content.setUser_id("59a4d04e299427043cea38c6");
//            contentDao.insert(content,"content");
            System.out.println("succ");
        }
        List<Content> list = contentDao.findAll();
        list.stream().forEach(content -> System.out.println(content.toString()));
        try{

//            Mongo mongo = new Mongo("127.0.0.1",27017);
//            DB db = mongo.getDB("zh");
//            Set<String> names = db.getCollectionNames();
//            names.forEach(System.out::println);
//            DBCollection dbCollection = db.getCollection("content");
//            BasicDBObject basicDBObject = new BasicDBObject();
//            basicDBObject.putAll(getValue(content));
//            dbCollection.insert(basicDBObject);
//            List<User> list = userService.findAll("user");
//            list.setId(null);
//            list.setEmail("aaa22222a@qq.com");
//            userService.insert(list,"zh");
//            for (User user:
//                 list) {
//                System.out.println(list.get(0).getEmail()+":"+list.get(0).getId());
//            }

            MongoClient client = new MongoClient(new MongoClientURI("mongodb://zh2:1234@127.0.0.1:22222/admin?options=admin"));
            MongoDatabase mongoDatabase = client.getDatabase("zh");
            Iterable<String> iterable = mongoDatabase.listCollectionNames();
            iterable.forEach((s)-> System.out.println(s));
            System.out.println(iterable.toString());

//            Mongo mongo = new Mongo("127.0.0.1",22222);
//            DB db = mongo.getDB("zh");
//            db.addUser("zh1","1234".toCharArray());
//            Set<String> names = db.getCollectionNames();
//            names.forEach(System.out::println);
//            DBCollection dbCollection = db.getCollection("test");
//            for (int i = 0; i < 1000000; i++) {
//                dbCollection.insert(BasicDBObject.parse("{_id:"+i+",key:\"a"+i+"\",value:"+i+"}"));
//            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map getValue(Object thisObj)
    {
        Map map = new HashMap();
        Class c;
        try
        {
            c = Class.forName(thisObj.getClass().getName());
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++)
            {
                String method = m[i].getName();
                if (method.startsWith("get"))
                {
                    try{
                        Object value = m[i].invoke(thisObj);
                        if (value != null)
                        {
                            String key=method.substring(3);
                            key=key.substring(0,1).toUpperCase()+key.substring(1);
                            map.put(method, value);
                        }
                    }catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("error:"+method);
                    }
                }
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        return map;
    }
}
