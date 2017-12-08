package Utils.POIUtils;
import org.apache.poi.hssf.usermodel.*;

import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * POI工具
 * Created by 刘志威 on 2017/10/25.
 */
public class CreationExecl {
    /**
     * 创建execl
     * @param list 传入的集合
     * @param <T> 不定数据类型
     * @throws Exception
     */
    public static<T> void creatExecl(List<T> list) throws Exception {
        // 创建一个Excel文件
        HSSFWorkbook workbook=new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet();
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 添加表头内容
        HSSFCell headCell;
        Class<?> tClass = list.get(0).getClass();
        Field[] fields = tClass.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            ColumnName annotation = fields[i].getAnnotation(ColumnName.class);
            headCell = hssfRow.createCell(i);
            if (annotation.getName()!=null) {
                headCell.setCellValue(annotation.getName());
            }else {
                headCell.setCellValue(fields[i].getName());
            }
            headCell.setCellStyle(cellStyle);
        }
        //集合长度叫size方法
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 1);
            T t = list.get(i);
            Class<?> aClass = t.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                // 设置可以访问私有字段
                declaredFields[j].setAccessible(true);
                //通过他获取get和set方法
                PropertyDescriptor descriptor=new PropertyDescriptor(declaredFields[j].getName(),aClass);
                Method getMethod=descriptor.getReadMethod();//获得get方法
                Object object=getMethod.invoke(t);//执行get方法返回一个Object 
                if (object!=null){
                HSSFCell cell = hssfRow.createCell(j);
                cell.setCellValue(object.toString());
                cell.setCellStyle(cellStyle);
                }
            }

        }
        OutputStream outputStream = new FileOutputStream("E:\\wps文件\\ExeclFile\\"+tClass.getSimpleName()+".xls");
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * 读取exec
     * @param path excel的路径
     * @param cls 要转入的数据类型
     * @param <T> 不定数据类型
     * @return 不定对象的集合
     * @throws Exception
     */
    public static <T> List<T> readExcel(String path,Class<T> cls) throws Exception{
        List<T> list = new ArrayList<T>();
        HSSFWorkbook workbook = null;
        // 读取Excel文件
        InputStream inputStream = new FileInputStream(path);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        // 循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                //实例化对象
                T t = cls.newInstance();
                // 获取类中所有的属性
                Field[] fid = cls.getDeclaredFields();
                // 遍历属性
                for (int i=0;i<fid.length;i++) {
                    HSSFCell cell = hssfRow.getCell(i);
                    // 设置可以访问私有字段
                    Field field = fid[i];
                    field.setAccessible(true);
                    // 为属性设置内容
                    Object object=cell.getStringCellValue();
                    String name = field.getType().getName();
                    String value=cell.getStringCellValue();
                    if (name.equals("java.lang.Integer")||name.equals("int")) {
                        field.set(t, Integer.parseInt(value));
                    }else {
                        field.set(t, value);
                    }
                }
                list.add(t);// 添加到集合
            }
        }
        return list;
    }
}
