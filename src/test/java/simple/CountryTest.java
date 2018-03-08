package simple;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.model.Country;

public class CountryTest {

	private static SqlSessionFactory sqlSessionFactory ;
	@BeforeClass
	public static void init(){
		try {
			//读取xml文件
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		     sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		    // reader.close();
		} catch (IOException e) {
			
		}finally {
			
		}	
	
	}
	/*@Test
	public void testSelectAll(){
		//打开sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Country> countries =sqlSession.selectList("selectAll") ;
		
	}*/
	@Test
	public void insetCountry(){
		CountryMapper countryMapper =sqlSessionFactory.openSession().getMapper(CountryMapper.class) ;
		
		Country country = new Country() ;
		
		country.setCountryname("日本");
		country.setCountrycode("RB");
		
		int result =countryMapper.insertCountry(country) ;
		sqlSessionFactory.openSession().commit();
		
		Assert.assertEquals(1, result);
		
		Assert.assertNotNull(country.getId());
		
	}
}
