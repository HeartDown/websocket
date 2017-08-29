import com.model.User;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangheng on 2017/8/7.
 */
public class TestDb {
    @Test
    public void testMongodb(){
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new
                    String[]{"classpath:applicationContext-mongo.xml",
                    "classpath:springmvc.xml"});
            UserService userService = (UserService) context.getBean("userService");

            User list = (User) userService.findById("1");
//            list.setId(null);
//            list.setEmail("aaa22222a@qq.com");
//            userService.insert(list,"zh");
//            for (User user:
//                 list) {
                System.out.println(list.getEmail()+":"+list.getId());
//            }
//            Mongo mongo = new Mongo("127.0.0.1",27017);
//            DB db = mongo.getDB("zh");
//            Set<String> names = db.getCollectionNames();
//            for (String name:
//                 names) {
//                System.out.println(name);
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
