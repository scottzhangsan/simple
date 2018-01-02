package tk.mybatis.simple.model;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

public class CountryTest {

	private static SqlSessionFactory sqlSessionFactory ;
	@BeforeClass
	public static void init(){
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		     sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		     reader.close();
		} catch (IOException e) {
			
		}finally {
			
		}	
	
	}
	@Test
	public void testSelectAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Country> countries =sqlSession.selectList("selectAll") ;
		printCountryList(countries);
	}
	
	private void printCountryList(List<Country> countries){
  for (Country country : countries) {
	System.out.println(country.getCountryname()+country.getCountrycode());
}		
	}
}
