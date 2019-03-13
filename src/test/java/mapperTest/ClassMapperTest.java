package mapperTest;

import cn.com.taiji.mapper.ClassMapper;
import cn.com.taiji.mapper.StudentMapper;
import cn.com.taiji.pojo.Class;
import cn.com.taiji.pojo.Student;
import cn.com.taiji.vo.StudentVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.PrivateKey;
import java.util.Map;

/**
 * @author fengliqiang
 * @date 2019/03/13/2:12 PM
 **/
public class ClassMapperTest {
    private ApplicationContext applicationContext;
    private ClassMapper classMapper;
    private StudentMapper studentMapper;

    @Before
    public void setup()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
        "springMVC-servlet.xml"});

        classMapper = (ClassMapper) applicationContext.getBean("classMapper");
        studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
    }

    @Test
    public void testInsertClass(){
        Class clazz = new Class(1,"语文","a302");
        int i = classMapper.insert(clazz);
        System.out.println(i);
    }

    @Test
    public void testSelectClass(){
        Class clazz =  classMapper.selectByPrimaryKey(1);
        System.out.println(clazz);
    }

    @Test
    public void testInsertStudent(){
        Student student = new Student(1,"fff","fff@qq.com","199545",1);
        Student student2 = new Student(2,"fff","fff@qq.com","199545",1);
        Student student3 = new Student(3,"fff","fff@qq.com","199545",1);

        studentMapper.insert(student);
        studentMapper.insert(student2);
        studentMapper.insert(student3);

        System.out.println("==========插入成功==============");
    }

    @Test
    public void testselectStuWithClassById(){
        Student student = studentMapper.selectStuWithClassById(1);
        System.out.println(student);

    }
}
