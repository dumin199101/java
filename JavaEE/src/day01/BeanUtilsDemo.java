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
    	 
    	 //ע������ת����
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
    	 
    	 //ע������ת������
    	 ConvertUtils.register(new DateLocaleConverter(), Date.class);
    	 
    	 //��������ֵ��
    	 BeanUtils.populate(p, hs);
    	 
    	 Date d = p.getBirthday();
    	 
    	 System.out.println(d.toLocaleString());
    	 
    	 System.out.println(p.getBirthday());
    	  
     }
     
     @Test
     public void test3() throws Exception{
    	  
    	 //�Լ�ʵ��һ������ת������
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
					throw new ConversionException("ֻ֧���ַ�������ת��");
				}
				
				String str = (String) value;
				
				if(str.trim().equals("")){
					return null;
				}
				
				//��ʱ��ת����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Date d = null;
				
				//��д���෽���������׳��ȸ��������쳣�������ಶ׽����
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
