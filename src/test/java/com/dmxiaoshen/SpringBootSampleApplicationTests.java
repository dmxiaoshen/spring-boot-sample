package com.dmxiaoshen;

import com.dmxiaoshen.model.Course;
import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.CourseService;
import com.dmxiaoshen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSampleApplication.class)
public class SpringBootSampleApplicationTests {

	@Autowired
	private UserService userService;
	@MockBean
	private CourseService courseService;

	@Test
	public void testAddUser(){
		User u = new User();
		u.setId("666");
		u.setAge(29);
		u.setMobilePhone("13387879898");
		u.setName("二愣子");
		userService.addUser(u);
	}

	@Test
	public void testGetUser(){
		System.out.println(userService.getUser("666"));
	}

	@Test
	public void test(){
		testAddUser();
		testGetUser();
		User u = new User();
		u.setAge(29);
		u.setMobilePhone("15478459865");
		u.setName("fss");
		userService.addUser(u);
		List<User> list = userService.page(1,20).getList();
		list.forEach(System.out::println);
	}

	@Test
	public void testMockCourse(){
		Course course = new Course();
		course.setStudentId("666");
		course.setName("语文");
		course.setScore(new BigDecimal("98"));
		Mockito.when(courseService.getCourseByStudentId("666")).thenReturn(course);
		testAddUser();
		User u = userService.getUser("666");
		Course c = courseService.getCourseByStudentId(u.getId());
		System.out.println(c);
	}

}
