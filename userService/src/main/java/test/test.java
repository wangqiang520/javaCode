package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	
	public static void main(String[] args) throws Exception {
		DocumentOtcRxSaveUpdateVo newObject=new DocumentOtcRxSaveUpdateVo();
		newObject.setProductName("new");
		
		DocumentOtcRx oldObject=new DocumentOtcRx();
		oldObject.setProductName("old");
		oldObject.setDocumentStatus(11);
		 aa(newObject,oldObject);
		
		//String s=(String) getGetMethod(newObject,oldObject);
		//System.out.println(s);
		//readAttributeValue(oldObject);
	}
	/**
     * 得到属性值
     * @param obj
     */
    public static void readAttributeValue(Object obj){
            String nameVlues="";
            //得到class
            Class cls = obj.getClass();
            //得到所有属性
            Field[] fields = cls.getDeclaredFields();
           for (int i=0;i<fields.length;i++){//遍历
               try {
                   //得到属性
                   Field field = fields[i];
                   //打开私有访问
                   field.setAccessible(true);
                   //获取属性
                   String name = field.getName();
                   //获取属性值
                   Object value = field.get(obj);
                   //一个个赋值
                   System.out.println(name+":"+value);
                   nameVlues += field.getName()+":"+value+",";
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }
           //获取最后一个逗号的位置　　　　　　　
           int lastIndex = nameVlues.lastIndexOf(",");
            //不要最后一个逗号","
            String  result= nameVlues.substring(0,lastIndex);
            System.out.println(result);
        }
	public static Object getGetMethod(Object ob , Object ol)throws Exception{
		Method[] m = ob.getClass().getMethods();
		Field[] field=ob.getClass().getDeclaredFields();
		
		Field[] olf=ol.getClass().getDeclaredFields();
		for(Field f:field) {
			f.setAccessible(true);
			String fildName=f.getName();
			System.out.println(f.get(fildName));
			for(Field ff:olf) {
				ff.setAccessible(true);
				String fildNames=f.getName();
				System.out.println(f.get(fildNames));
			}
			System.out.println();
		}
		/*for(int i = 1;i < m.length;i++){
			if(("get"+name).toLowerCase().equals(m[i].getName().toLowerCase())){
				System.out.println(m[i].getName());
				System.out.println(m[i].invoke(ob));
				System.out.println();
			}
		}*/
		return null;
	}
	
	
	
	
	public static boolean aa(Object newObject, Object oldObject) throws Exception {
		Field[] newFields = newObject.getClass().getDeclaredFields();
		Field[] oldFields = oldObject.getClass().getDeclaredFields();
		boolean result = true;// true_代表数据未修改，false代表数据有修改
		for(Field newField:newFields) {
			for(Field oldField:oldFields) {
				String newFieldName=newField.getName();
				String oldFieldName=oldField.getName();
				newField.setAccessible(true);
				oldField.setAccessible(true);
				//if(newFieldName.equals(oldFieldName)) {
					System.out.println(newFieldName+":"+newField.get(newFieldName));
					//System.out.println(oldFieldName+":"+oldField.get(oldFieldName));
					/*Object newFieldValue=newField.get(newFieldName);
					Object oldFieldValue=oldField.get(oldFieldName);
					if(!(newFieldValue.equals(oldFieldValue))) {
						result=false;
						break;
					}*/
				//}
			}
		}
		
		
		return result;
	}

	
	
}
