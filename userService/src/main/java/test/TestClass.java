package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        DocumentOtcRxSaveUpdateVo source=new DocumentOtcRxSaveUpdateVo();
        DocumentOtcRx target=new DocumentOtcRx();
        source.setProductName("wangqiang");
        source.setCraft("ssss");
        source.setIndication("12");
 


        target.setProductName("wangqiang");
        target.setCraft("ssss");
        target.setIndication("12");

        try {
            Boolean isEquals=isEqualsBean(source,target);
            System.out.println(isEquals);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Boolean isEqualsBean(Object source,Object target) throws Exception {
        boolean isEquals=true;
        Class<?> srcClass = source.getClass();
        Field[] fields=srcClass.getDeclaredFields();
        for(Field field:fields){
            String fieldName=field.getName();
            System.out.println(field.getType());
            
            
            Object sourceValue=getClassValue(source,fieldName);
            Object targetValue=getClassValue(target,fieldName);

            if(sourceValue!=null && targetValue!=null){
                if(!sourceValue.equals(targetValue)){
                    isEquals=false;
                    break;
                }
            }
            if(!(sourceValue==targetValue)){

                isEquals=false;
                break;
            }

        }
        return isEquals;
    }
    /**
     * 获取值
     * @Title: getClassValue 
     * @Description: 
     * @param obj
     * @param fieldName
     * @return
     * @throws Exception Object
     * @throws
     */
    public static Object getClassValue(Object obj, String fieldName) throws Exception {
        if(obj ==null){
            return null;
        }
        Object objValue = null;
        Class beanClass=obj.getClass();
        Method[] methods=beanClass.getMethods();
        for(Method method:methods){
            if(!method.getName().startsWith("get")){
                continue;
            }
            if (method.getName().toUpperCase().equals(fieldName.toUpperCase())
                    || method.getName().substring(3).toUpperCase().equals(fieldName.toUpperCase())) {
                objValue = method.invoke(obj, new Object[] {});
                break;
            }
        }
        return objValue;
    }
}
