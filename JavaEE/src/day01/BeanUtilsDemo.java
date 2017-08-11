package day01;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class BeanUtilsDemo {
     @Test
	 public void test() throws Exception{
    	 
    	 Person p = new Person();
    	 
    	 String name = "dumin";
    	 String age = "24";
    	 String birthday = "1991-12-01";
    	 
    	 //注册日期转换器
    	 ConvertUtils.register(new  DateLocaleConverter(), Date.class);
    	 
    	 BeanUtils.setProperty(p, "name", name);
    	 BeanUtils.setProperty(p, "age", age);
    	 BeanUtils.setProperty(p, "birthday", birthday);
    	 
    	 
    	 System.out.println(p.getBirthday());
     }
     
     @Test
     public void test2() throws Exception{
    	 
    	 Person p = new Person();
    	 
    	 HashMap<String,String> hs = new HashMap<String,String>();
    	 
    	 hs.put("name", "dumin");
    	 hs.put("age", "22");
    	 hs.put("birthday", "1980-01-02");
    	 
    	 //注册日期转换器：
    	 ConvertUtils.register(new DateLocaleConverter(), Date.class);
    	 
    	 //设置属性值：
    	 BeanUtils.populate(p, hs);
    	 
    	 Date d = p.getBirthday();
    	 
    	 System.out.println(d.toLocaleString());
    	 
    	 System.out.println(p.getBirthday());
    	  
     }
     
     @Test
     public void test3() throws Exception{
    	  
    	 //自己实现一个日期转换器：
    	 Person p = new Person();
    	 String name = "dumin";
    	 String age = "22";
    	 String birthday = "1991-12-01 13:11:32";
    	 
    	 ConvertUtils.register(new Converter() {
			
			@Override
			public <T> T convert(Class<T> type, Object value) {
				
				if(value==null){
					return null;
				}
				
				if(!(value instanceof String)){
					throw new ConversionException("只支持字符串类型转换");
				}
				
				String str = (String) value;
				
				if(str.trim().equals("")){
					return null;
				}
				
				//做时间转换：
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Date d = null;
				
				//重写父类方法，不能抛出比父类更多的异常，否则父类捕捉不到
				try {
					d = sdf.parse(str);
				} catch (ParseException e) {
					 throw new RuntimeException(e);
				}
				
				return (T) d;
				
				
				
				
			}
		}, Date.class);
    	 
    	 
    	 BeanUtils.setProperty(p, "name", name);
    	 BeanUtils.setProperty(p, "age", age);
    	 BeanUtils.setProperty(p, "birthday", birthday);
    	 
    	 
    	 System.out.println(p.getBirthday());
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }
}
